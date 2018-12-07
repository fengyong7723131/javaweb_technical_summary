package com.product.service.solr.impl;

import com.fengyong.base.beans.page.QueryBean;
import com.fengyong.base.rely.ResultPoBean;
import com.fengyong.utils.CheckUtils;
import com.product.core.solr.SolrConstants;
import com.product.core.solr.SolrPramConstants;
import com.product.po.solr.ProductSolrPo;
import com.product.po.solr.SearchableSolrProductIndexDefinition;
import com.product.po.solr.SolrProductIndex;
import com.product.po.solr.SolrResultPo;
import com.product.service.solr.SolrProductService;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FacetOptions;
import org.springframework.data.solr.core.query.FacetQuery;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 17/1/4 上午11:04.
 */
@Service
public class SolrProductServiceImpl extends SimpleSolrRepository<SolrProductIndex,String> implements SolrProductService {
    @Autowired(required = false)
    private SolrTemplate solrProductTemplate;

    /**
     * 添加索引,无提交
     * @param beans
     * @return
     */
    @Override
    public UpdateResponse saveBeans(Collection<?> beans) {
        return solrProductTemplate.saveBeans(beans);
    }

    /**
     * solr主查询方法
     * @param queryBean 查询参数
     * @return  封装result数据
     */
    @Override
    public ResultPoBean<SolrResultPo> querySolrProduct(QueryBean queryBean) {
        //获取FacetQuery
        FacetQuery facetQuery=getFacetQuery(queryBean);

        //添加高亮字段
        List<String> list=new ArrayList<>();
        list.add(SearchableSolrProductIndexDefinition.PRODNAME_FIELD_NAME);

        //查询
        QueryResponse queryResponse=solrProductTemplate.queryForFacetHightResponse(facetQuery,SolrProductIndex.class,list);

        //解析结果数据
        ResultPoBean<SolrResultPo> resultPoBean=getResultPoBean(queryResponse);

        return resultPoBean;
    }




    /**
     * 封装ResultPoBean
     * @param queryResponse solr查询返回的原始数据
     * @return  ResultPoBean
     */
    private ResultPoBean<SolrResultPo> getResultPoBean(QueryResponse queryResponse){
        ResultPoBean<SolrResultPo> resultPoBean = new ResultPoBean<>();
        SolrResultPo solrResultPo=new SolrResultPo();

        //获取response中的商品集合,并转换
        List<SolrProductIndex> solrProductIndexList=solrProductTemplate.convertQueryResponseToBeans(queryResponse,SolrProductIndex.class);
        //类型转换与替换高亮字段名称
        List<ProductSolrPo> productSolrPoList = replaceClassAndHL(solrProductIndexList,queryResponse);
        solrResultPo.setProductSolrPoList(productSolrPoList);

        //获取response中的facetField集合
        Map<String,List<String>> map = getFacetFields(queryResponse);
        solrResultPo.setFacetFields(map);

        //设置数据总数,分页使用
        solrResultPo.setCount(new Long(queryResponse.getResults().getNumFound()).intValue());
        resultPoBean.success(solrResultPo);
        return resultPoBean;

    }


    /**
     * solrPo到javaPo的转换,高亮字段的替换
     * @param solrProductIndexList  solrPo集合
     * @param queryResponse solr数据
     * @return  javaPo集合
     */
    private  List<ProductSolrPo> replaceClassAndHL(List<SolrProductIndex> solrProductIndexList, QueryResponse queryResponse)   {
        //获取所有高亮的字段
        Map<String,Map<String,List<String>>> highlightMap=queryResponse.getHighlighting();
        List<ProductSolrPo> productSolrPoList = new ArrayList<>();
        ProductSolrPo productSolrPo = null;
        if(solrProductIndexList.size() == highlightMap.size()){
            for(SolrProductIndex solrProductIndex:solrProductIndexList){
                //设置高亮字段,prodName
                if(CheckUtils.isNotEmpty(highlightMap.get(solrProductIndex.getItemId()).get(SearchableSolrProductIndexDefinition.PRODNAME_FIELD_NAME))){
                    solrProductIndex.setProdName(highlightMap.get(solrProductIndex.getItemId()).get(SearchableSolrProductIndexDefinition.PRODNAME_FIELD_NAME).get(0));
                }
                //转换成javaPo
                productSolrPo = new ProductSolrPo();
                productSolrPo.fromPo(solrProductIndex);
                productSolrPoList.add(productSolrPo);
            }
        }else {
            return null;
        }
        return productSolrPoList;
    }

    /**
     * 获取facet数据
     * @param queryResponse solr查询返回的原始数据
     * @return  facet数据
     */
    private Map<String,List<String>> getFacetFields(QueryResponse queryResponse)  {
        List<FacetField> facetFields = queryResponse.getFacetFields();

        //创建facet集合返回数据
        Map<String,List<String>> map=new LinkedHashMap<>();
        Set<String> set = null;
        List<String> list = null;
        for (FacetField facetField:facetFields){
            if(SearchableSolrProductIndexDefinition.FILTERQUERYITEMSPECLIST_FIELD_NAME.equals(facetField.getName())){
                for (FacetField.Count facetFieldValue:facetField.getValues()){
                    //filterQueryItem_94_颜色_白色
                    String[] strings = facetFieldValue.getName().replace(SolrConstants.FILTERQUERYITEM,"").split(SolrConstants.XIAHUAXIAN);
                    //94_颜色
                    String key=strings[0]+SolrConstants.XIAHUAXIAN+strings[1];
                    //白色
                    String value=strings[2];

                    if(map.get(key)==null){
                        set = new HashSet<>();
                        list = new ArrayList<>();
                    }
                    if(set.add(value)){
                        list.add(value);
                    }
                    map.put(key,list);
                }
            }else if(SearchableSolrProductIndexDefinition.BRANDID_FIELD_NAME.equals(facetField.getName())){
                set = new HashSet<>();
                list = new ArrayList<>();
                for (FacetField.Count facetFieldValue:facetField.getValues()){
                    if(set.add(facetFieldValue.getName())){
                        list.add(facetFieldValue.getName());
                    }
                }
                map.put("品牌",list);
            }else if(SearchableSolrProductIndexDefinition.PRICE_FIELD_NAME.equals(facetField.getName())){
                List<Double> listPrice = new LinkedList<>();
                for (FacetField.Count facetFieldValue:facetField.getValues()){
                    listPrice.add(Double.valueOf(facetFieldValue.getName())/*+SolrConstants.XIAHUAXIAN+facetFieldValue.getCount()*/);
                }
                List<String> priceList = getPriceQujian(listPrice);
                map.put("价格",priceList);
            }
        }

        return map;
    }

    private List<String> getPriceQujian(List<Double> list){
        if(list==null || list.size()==0){
            return null;
        }
        //数据个数
        Integer size = list.size();
        //最大值
        double max = list.get(size-1);
        //获取区间集合
        List<String> priceList = getPriceSection(max,list);
        return priceList;
    }

    /**
     * 获取区间集合
     * @param max   价格最大值
     * @param list  价格集合
     * @return  区间集合
     */
    private List<String> getPriceSection(double max,List<Double> list) {
        List<String> priceList = new LinkedList<>();
        if(max<10){
            return null;
        }else if(max>10 && max/10>1 && max<100){
            //获取到0-10 10-20..的区间集合
            priceList = getMap(100,list);
        }else if(max>100 && max/100>1 && max<1000){
            //获取0-100 100-200..的区间集合
            priceList = getMap(1000,list);
        }else if(max>1000 && max/1000>1 && max<10000){
            //获取0-1000 ...
            priceList = getMap(10000,list);
        }else if(max>10000 && max/10000>1){
            //获取0-10000
            priceList = getMap(100000,list);
        }
        return priceList;
    }

    /**
     * 获取区间集合
     * @param integer   最大价格向上取整
     * @param list  价格集合
     * @return  获取区间集合
     */
    private  List<String> getMap(Integer integer,List<Double> list){
        List<String> priceList = new LinkedList<>();
        Map<String,Double> map = new LinkedHashMap<>();
        Integer num = integer/10;
        for(int i=0;i<10;i++){
            map.put(num*i + "-" + (num*(i+1)-1),null);
            for(Double price:list){
                if(num*i<price && price<num*(i+1)){
                    map.put(num*i + "-" + (num*(i+1)-1),price);
                }
            }
        }

        Iterator<Map.Entry<String, Double>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Double> entry=it.next();
            String key=entry.getKey();
            if(map.get(key)==null){
                it.remove();
            }
        }
        Iterator<Map.Entry<String, Double>> it1 = map.entrySet().iterator();
        int i = 0;
//        while(it1.hasNext()){
//            Map.Entry<String, Double> entry=it1.next();
//            String key=entry.getKey();
//            if(!key.split("-")[0].equals("0") && i==0){
//                it1.remove();
//                map.put("0-"+key.split("-")[1],Double.valueOf(1));
//            }
//            i++;
//
//        }
        Iterator<Map.Entry<String, Double>> it2 = map.entrySet().iterator();
        while(it2.hasNext()){
            Map.Entry<String, Double> entry=it2.next();
            String key=entry.getKey();
            priceList.add(key);
        }
        return priceList;
    }



    /**
     * 组装SolrQuery
     * @param queryBean queryBean
     * @return  SolrQuery
     */
    private FacetQuery getFacetQuery(QueryBean queryBean) {
        //初始化FacetQuery
        SimpleFacetQuery sfq=new SimpleFacetQuery();

        //设置属性分组字段分组字段
        FacetOptions facetOptions=new FacetOptions(SearchableSolrProductIndexDefinition.FILTERQUERYITEMSPECLIST_FIELD_NAME);//这里是分组字段
        //设置品牌分组字段
        facetOptions.addFacetOnField(SearchableSolrProductIndexDefinition.BRANDNAME_FIELD_NAME);
        //设置价格分组字段,用于计算价格区间
        facetOptions.addFacetOnField(SearchableSolrProductIndexDefinition.PRICE_FIELD_NAME);
        facetOptions.setFacetSort(FacetOptions.FacetSort.INDEX);
        //设置facetlimit
        facetOptions.setFacetLimit(100000);
        sfq.setFacetOptions(facetOptions);




//        //促销过滤查询
//        long date = System.currentTimeMillis();
//        sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.PROMSTARTTIME_FIELD_NAME).between(date,date,true,false).or(SearchableSolrProductIndexDefinition.PROMSTARTTIME_FIELD_NAME).is("0")));
//        sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.PROMENDTIME_FIELD_NAME).between(date,date,false,true).or(SearchableSolrProductIndexDefinition.PROMENDTIME_FIELD_NAME).is("0")));

        //q 关键字 多个关键词使用空格隔开
        if(CheckUtils.hasLength(queryBean.getParaValue(SolrPramConstants.Q))){
            String[] strings=queryBean.getParaValue(SolrPramConstants.Q).split(SolrConstants.SPASE);
            if(CheckUtils.isNotNull(strings) && strings.length>0){
                for (int i=0;i<strings.length;i++){
                    sfq.addCriteria(new Criteria(SolrConstants.Q_FIELD).expression(strings[i]));
                }
            }
        }else {
            sfq.addCriteria(new Criteria(SolrConstants.WILDCARD).expression(SolrConstants.WILDCARD));
        }

        //品牌过滤查询
        if(CheckUtils.hasLength(queryBean.getParaValue(SolrPramConstants.BRANDID))){
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.BRANDID_FIELD_NAME).is(queryBean.getParaValue(SolrPramConstants.BRANDID))));
        }
        //设置是否有库存
        if(CheckUtils.hasLength(queryBean.getParaValue(SolrPramConstants.STOCK))){
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.STOCK_FIELD_NAME).between("1",SolrPramConstants.STOCK,false,true)));
        }

        //属性过滤条件  filterQueryItem_94_颜色:黑色,白色;filterQueryItem_95_型号;
        String[] strings1=null;
        String[] strings2=null;
        if(CheckUtils.hasLength(queryBean.getParaValue(SolrPramConstants.ATTR))){
            //strings   filterQueryItem_94_颜色:黑色,白色
            String[] strings=queryBean.getParaValue(SolrPramConstants.ATTR).split(SolrConstants.FENHAO);
            if(CheckUtils.isNotNull(strings) && strings.length>0){
                for (int i=0;i<strings.length;i++){
                    //strings1  filterQueryItem_94_颜色 黑色,白色
                    strings1=strings[i].split(SolrConstants.MAOHAO);
                    //同一属性时选择多个值时,为或者关系 反之为与的关系
                    if(strings1[1].split(SolrConstants.DOUHAO).length>1){//或者的关系
                        //strings2   黑色,白色
                        strings2=strings1[1].split(SolrConstants.DOUHAO);
                        //黑色,白色  进行拼装
                        StringBuffer filterString=new StringBuffer();
                        //price:11 OR price:44 OR price:211
                        for (int j=0;j<strings2.length;j++){
                            filterString.append(SolrConstants.FILTERQUERYITEM+strings1[0]+SolrConstants.MAOHAO+strings2[j]+SolrConstants.OR);
                        }
                        filterString.delete(filterString.length()-4,filterString.length());
                        sfq.addFilterQuery(new SimpleQuery(filterString.toString()));
                    }else {//filterQueryItem_95_型号;
                        //过滤查询时,contains类似于like,is是类似于==.结论:过滤查询用is
                        sfq.addFilterQuery(new SimpleQuery(new Criteria(SolrConstants.FILTERQUERYITEM+strings1[0]).is(strings1[1])));
                    }
                }
            }
        }

        //平台类别过滤查询
        if(CheckUtils.hasLength(queryBean.getParaValue(SolrPramConstants.CATEID))){
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.CATEID_FIELD_NAME).is(queryBean.getParaValue(SolrPramConstants.CATEID))));
        }
        //商户类别过滤查询
        if(CheckUtils.hasLength(queryBean.getParaValue(SolrPramConstants.STOREID+SolrPramConstants.STORECATEID))){
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.STOREID_FIELD_NAME).is(queryBean.getParaValue(SolrPramConstants.STOREID))));
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.STORECATEID_FIELD_NAME).is(queryBean.getParaValue(SolrPramConstants.STORECATEID))));
        }

        //价格区间过滤查询
        String startPrice=queryBean.getParaValue(SolrPramConstants.STARTPRICE);
        String endPrice=queryBean.getParaValue(SolrPramConstants.ENDPRICE);
        if(CheckUtils.hasLength(startPrice) && CheckUtils.hasLength(endPrice)){
            //start与end区间查询
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.PRICE_FIELD_NAME).between(startPrice,endPrice)));
        }else if(CheckUtils.hasLength(startPrice) && CheckUtils.isNull(endPrice)){
            //大于start的数据
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.PRICE_FIELD_NAME).between(startPrice,endPrice,false,true)));
        }else if(CheckUtils.isNull(startPrice) && CheckUtils.hasLength(endPrice)){
            //小于end的数据
            sfq.addFilterQuery(new SimpleQuery(new Criteria(SearchableSolrProductIndexDefinition.PRICE_FIELD_NAME).between(startPrice,endPrice,true,false)));
        }

        //Sort 排序条件 sort=price asc
        if(CheckUtils.hasLength(queryBean.getParaValue(SolrPramConstants.SORT))){
            //sort=price asc
            String[] sortPram=queryBean.getParaValue(SolrPramConstants.SORT).split(SolrConstants.SPASE);
            if(sortPram.length>1){
                Sort.Direction direction=SolrConstants.SORT_DESC.equals(sortPram[1])?Sort.Direction.DESC:Sort.Direction.ASC;
                Sort sort = new Sort(direction, sortPram[0]);
                //.and(new Sort(Sort.Direction.ASC, "id"));
                sfq.addSort(sort);
            }
        }

        //设置分页信息
        sfq.setPageRequest(new SolrPageRequest(queryBean.getBeginCount(),queryBean.getPageRows()));
        return sfq;
    }



}
