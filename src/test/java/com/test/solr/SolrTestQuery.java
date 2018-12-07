package com.test.solr;

import com.fengyong.base.beans.page.QueryBean;
import com.fengyong.base.rely.ResultPoBean;
import com.product.core.solr.SolrPramConstants;
import com.product.po.solr.SolrProductIndex;
import com.product.po.solr.SolrResultPo;
import com.product.service.solr.SolrProductService;
import com.test.BaseTest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 17/1/4 下午1:46.
 */
public class SolrTestQuery extends BaseTest {
    @Autowired
    private SolrProductService solrProductService;


    /**
     * 查询
     */
    @Test
    public void query() {
        QueryBean queryBean = new QueryBean();
//        queryBean.addF(SolrPramConstants.Q,"手机");    //关键字查询
//        queryBean.addF(SolrPramConstants.ATTR,"94_颜色:白色;95_风格:商务正装"); //属性过滤查询
//        queryBean.addF(SolrPramConstants.STARTPRICE,"500");   //价格起始
//        queryBean.addF(SolrPramConstants.ENDPRICE,"1000");  //价格结束
//        queryBean.addF(SolrPramConstants.SORT,"id asc");    //按照价格排序
//        queryBean.addF(SolrPramConstants.CATEID,"011");     //类别id
//        queryBean.addF(SolrPramConstants.BRANDID,null);     //品牌id

        Long start = System.currentTimeMillis();
        int i = 10;
        queryBean.setPageRows(20);
        queryBean.setTotalCount(5000000);
        queryBean.setPageNo(i++);
        ResultPoBean<SolrResultPo> resultPoBean = solrProductService.querySolrProduct(queryBean);
        System.out.println("");

        Long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLL" + (end - start));
        System.out.println("");
    }

    @Test
    public void add() {
        for (int i = 0; i < 1; i++) {
            List<SolrProductIndex> list = createProductList( 1* i,  1* (i + 1));
            UpdateResponse ss = solrProductService.saveBeans(list);
            list = null;
        }
        System.out.print("");
    }

    /**
     * 获取多个商品
     *
     * @return
     */
    protected List<SolrProductIndex> createProductList(int start, int end) {
        List<SolrProductIndex> products = new ArrayList<>(end - start);
        for (int i = start; i < end; i++) {
            products.add(createProduct(i));
        }
        return products;
    }


    /**
     * 获取单个product
     *
     * @param id 定义主键
     * @return
     */
    protected SolrProductIndex createProduct(int id) {
        SolrProductIndex product = new SolrProductIndex();
        product.setItemId(id + "");
        product.setProdId(getRan(100) + "");
        String name = getProdName();
        product.setProdName(name.replaceAll("商务旗舰", ""));
        product.setMerItemName(name);
        product.setPrice(new Float(getRan(10000)));
        product.setOnSaleTime(new Date());

        Map<String, List<String>> map = new HashMap<>();
        map.put("94_颜色", getColor());
        map.put("95_风格", getSize());
        List<String> attrs = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            attrs.add(entry.getKey() + "_" + entry.getValue().get(0));
        }
        product.setFilterQuerySpuAttrList(attrs);
        product.setFilterQuerySpuAttrMap(map);
        product.setBrandName(getBrand());
        return product;
    }

    public String getProdName() {
        String[] strings = {"苹果手机", "商务旗舰华为手机", "安全第一金立手机", "照亮你的美vivo手机", "充电一分钟oppo手机", "步步高音乐手机", "不安全三星爆炸手机", "小米手机", "小米note2", "小米mix"};
        return strings[getRan(10)];
    }

    public List getColor() {
        String[] strings = {"红色", "橙色", "黄色", "绿色", "青色", "紫色", "白色", "黑色", "灰色", "透明"};
        List list = new ArrayList<>();
        int j = getRan(10) + 1;
        for (int i = 0; i < j; i++) {
            list.add(strings[getRan(10)]);
        }
        return list;
    }

    public List getSize() {
        String[] strings = {"嘻哈", "英式学院", "工装军旅", "商务正装", "日系复古", "美式休闲", "小清新", "欧美简约", "基础大众", "精致韩风"};
        List list = new ArrayList<>();
        int j = getRan(10) + 1;
        for (int i = 0; i < j; i++) {
            list.add(strings[getRan(10)]);
        }
        return list;
    }

    public String getBrand() {
        String[] strings = {"Mark Fairwhale", "马克华菲", "Jack Jones", "杰克琼斯", "GXGtonlion", "唐狮", "卡宾", "威可多", "劲霸", "优衣库"};
        return strings[getRan(10)];
    }

    public int getRan(int i) {
        return (int) (Math.random() * (i));
    }
}
