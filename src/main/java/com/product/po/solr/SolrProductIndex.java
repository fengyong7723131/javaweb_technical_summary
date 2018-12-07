package com.product.po.solr;

import com.fengyong.base.beans.Po;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Dynamic;

import java.util.*;


/**
 * 类描述:Solr索引Po类
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/5/3 下午5:21.
 */
public class SolrProductIndex extends Po implements SearchableSolrProductIndexDefinition {
    /**
     * prodId
     */

    @Field(PRODID_FIELD_NAME)
    private String prodId;

    /**
     * 商品全称
     */
    @Field(PRODNAME_FIELD_NAME)
    private String prodName;

    /**
     * 主展示分类的一级分类code
     */
    @Field(ACATE_FIELD_NAME)
    private String aCate;

    /**
     * 主展示分类code
     */
    @Field(CATEID_FIELD_NAME)
    private String cateId;

    /**
     * 展示分类code
     */
    @Field(CATEIDARRAY_FIELD_NAME)
    private List<String> cateIdArray;

    /**
     * 展示分类名字
     */
    @Field(CATENAMEARRAY_FIELD_NAME)
    private List<String> cateNameArray;

    /**
     * 店铺主展示分类code
     */
    @Field(STORECATEID_FIELD_NAME)
    private String storeCateId;

    /**
     * 店铺展示分类code
     */
    @Field(STORECATEIDARRAY_FIELD_NAME)
    private List<String> storeCateIdArray;

    /**
     * 店铺展示分类名字
     */
    @Field(STORECATENAMEARRAY_FIELD_NAME)
    private List<String> storeCateNameArray;

    /**
     * 关键字
     */
    @Field(KEYWORD_FIELD_NAME)
    private List<String> keyword;

    /**
     * 品牌id
     */
    @Field(BRANDID_FIELD_NAME)
    private String brandId;

    /**
     * 品牌名称
     */
    @Field(BRANDNAME_FIELD_NAME)
    private String brandName;

    /**
     * 企业id
     */
    @Field(ENTID_FIELD_NAME)
    private String entId;

    /**
     * 企业名称
     */
    @Field(ENTNAME_FIELD_NAME)
    private String entName;

    /**
     * 店铺id
     */
    @Field(STOREID_FIELD_NAME)
    private String storeId;

    /**
     * 店铺名称
     */
    @Field(STORENAME_FIELD_NAME)
    private String storeName;

    /**
     * 生产厂商
     */
    @Field(PRODMFRS_FIELD_NAME)
    private String prodMfrs;

    /**
     * 评论数量
     */
    @Field(COMMCOUNT_FIELD_NAME)
    private Integer commCount;

    /**
     * 评论星级
     */
    @Field(COMMSTAR_FIELD_NAME)
    private String commStar;

    /**
     * 好评率
     */
    @Field(BESTCOMM_FIELD_NAME)
    private String bestComm;

    /**
     * itemId
     */
    @Id
    @Field(ITEMID_FIELD_NAME)
    private String itemId;

    /**
     * 商品价格
     */
    @Field(PRICE_FIELD_NAME)
    private Float price;

    /**
     * SKU市场价格
     */
    @Field(MARKETPRICE_FIELD_NAME)
    private Float marketPrice;

    /**
     * 商品主图片
     */
    @Field(SKUIMG_FIELD_NAME)
    private String skuImg;

    /**
     * 商品小图片
     */
    @Field(IMGS)
    private List<String> imgs;
    /**
     * 商品售卖标题
     */
    @Field(MERITEMNAME_FIELD_NAME)
    private String merItemName;

    /**
     * 商品售卖子标题
     */
    @Field(SUBMERITEMNAME_FIELD_NAME)
    private String subMerItemName;

    /**
     * 销量
     */
    @Field(ITEMSALES_FIELD_NAME)
    private Long itemSales;

    /**
     * 库存
     */
    @Field(STOCK_FIELD_NAME)
    private Long stock;

    /**
     * 上架时间
     */
    @Field(ONSALETIME_FIELD_NAME)
    private Date onSaleTime;

    /**
     * 促销id
     */
    @Field(PROMOTIONID_FIELD_NAME)
    private String promotionId;

    /**
     * 促销类型
     */
    @Field(PROMOTIONTYPE_FIELD_NAME)
    private Integer promotionType;

    /**
     * 促销开始时间-时间戳
     */
    @Field(PROMSTARTTIME_FIELD_NAME)
    private Long promStartTime;

    /**
     * 促销结束时间-时间戳
     */
    @Field(PROMENDTIME_FIELD_NAME)
    private Long promEndTime;

    /**
     * 商品基本属性集合
     */
    @Dynamic
    @Field(FILTERQUERYITEMSPECMAP_FIELD_NAME)
    private Map<String, List<String>> filterQuerySpuAttrMap;

    /**
     * 商品基本属性集合
     */
    @Field(FILTERQUERYITEMSPECLIST_FIELD_NAME)
    private List<String> filterQuerySpuAttrList;

    /**
     * 商品品规属性集合
     */

   // private Map<String, String> filterQueryItemSpecMap;

    /**
     * 商品品规属性集合
     */

   // private List<String> filterQueryItemSpecList;


    /**
     * Gets 店铺名称.
     *
     * @return Value of 店铺名称.
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Gets 好评率.
     *
     * @return Value of 好评率.
     */
    public String getBestComm() {
        return bestComm;
    }

    /**
     * Gets 评论星级.
     *
     * @return Value of 评论星级.
     */
    public String getCommStar() {
        return commStar;
    }

    /**
     * Gets SKU市场价格.
     *
     * @return Value of SKU市场价格.
     */
    public Float getMarketPrice() {
        return marketPrice;
    }

    /**
     * Gets 商品售卖标题.
     *
     * @return Value of 商品售卖标题.
     */
    public String getMerItemName() {
        return merItemName;
    }


    /**
     * Sets new prodId.
     *
     * @param prodId New value of prodId.
     */
    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    /**
     * Sets new 销量.
     *
     * @param itemSales New value of 销量.
     */
    public void setItemSales(Long itemSales) {
        this.itemSales = itemSales;
    }

    /**
     * Sets new 生产厂商.
     *
     * @param prodMfrs New value of 生产厂商.
     */
    public void setProdMfrs(String prodMfrs) {
        this.prodMfrs = prodMfrs;
    }

    /**
     * Gets 店铺展示分类名字.
     *
     * @return Value of 店铺展示分类名字.
     */
    public List<String> getStoreCateNameArray() {
        return storeCateNameArray;
    }

    /**
     * Sets new 企业id.
     *
     * @param entId New value of 企业id.
     */
    public void setEntId(String entId) {
        this.entId = entId;
    }

    /**
     * Sets new 店铺主展示分类code.
     *
     * @param storeCateId New value of 店铺主展示分类code.
     */
    public void setStoreCateId(String storeCateId) {
        this.storeCateId = storeCateId;
    }

    /**
     * Gets 店铺id.
     *
     * @return Value of 店铺id.
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * Sets new 评论数量.
     *
     * @param commCount New value of 评论数量.
     */
    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }

    /**
     * Sets new 品牌名称.
     *
     * @param brandName New value of 品牌名称.
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Gets 促销id.
     *
     * @return Value of 促销id.
     */
    public String getPromotionId() {
        return promotionId;
    }

    /**
     * Gets 库存.
     *
     * @return Value of 库存.
     */
    public Long getStock() {
        return stock;
    }

    /**
     * Sets new 促销类型.
     *
     * @param promotionType New value of 促销类型.
     */
    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    /**
     * Gets 促销类型.
     *
     * @return Value of 促销类型.
     */
    public Integer getPromotionType() {
        return promotionType;
    }

    /**
     * Sets new 展示分类code.
     *
     * @param cateIdArray New value of 展示分类code.
     */
    public void setCateIdArray(List<String> cateIdArray) {
        this.cateIdArray = cateIdArray;
    }

    /**
     * Gets 商品价格.
     *
     * @return Value of 商品价格.
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Gets itemId.
     *
     * @return Value of itemId.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets new 商品基本属性集合.
     *
     * @param filterQuerySpuAttrMap New value of 商品基本属性集合.
     */
    public void setFilterQuerySpuAttrMap(Map<String, List<String>> filterQuerySpuAttrMap) {
        this.filterQuerySpuAttrMap = filterQuerySpuAttrMap;
    }

    /**
     * Gets 店铺主展示分类code.
     *
     * @return Value of 店铺主展示分类code.
     */
    public String getStoreCateId() {
        return storeCateId;
    }

    /**
     * Gets 生产厂商.
     *
     * @return Value of 生产厂商.
     */
    public String getProdMfrs() {
        return prodMfrs;
    }

    /**
     * Sets new 评论星级.
     *
     * @param commStar New value of 评论星级.
     */
    public void setCommStar(String commStar) {
        this.commStar = commStar;
    }

    /**
     * Sets new itemId.
     *
     * @param itemId New value of itemId.
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets 销量.
     *
     * @return Value of 销量.
     */
    public Long getItemSales() {
        return itemSales;
    }

    /**
     * Gets 关键字.
     *
     * @return Value of 关键字.
     */
    public List<String> getKeyword() {
        return keyword;
    }

    /**
     * Gets 展示分类名字.
     *
     * @return Value of 展示分类名字.
     */
    public List<String> getCateNameArray() {
        return cateNameArray;
    }

    /**
     * Gets 评论数量.
     *
     * @return Value of 评论数量.
     */
    public Integer getCommCount() {
        return commCount;
    }

    /**
     * Gets 主展示分类code.
     *
     * @return Value of 主展示分类code.
     */
    public String getCateId() {
        return cateId;
    }

    /**
     * Sets new 企业名称.
     *
     * @param entName New value of 企业名称.
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * Gets 商品售卖子标题.
     *
     * @return Value of 商品售卖子标题.
     */
    public String getSubMerItemName() {
        return subMerItemName;
    }

    /**
     * Gets 主展示分类的一级分类code.
     *
     * @return Value of 主展示分类的一级分类code.
     */
    public String getACate() {
        return aCate;
    }

    /**
     * Sets new 店铺展示分类code.
     *
     * @param storeCateIdArray New value of 店铺展示分类code.
     */
    public void setStoreCateIdArray(List<String> storeCateIdArray) {
        this.storeCateIdArray = storeCateIdArray;
    }

    /**
     * Sets new 商品售卖子标题.
     *
     * @param subMerItemName New value of 商品售卖子标题.
     */
    public void setSubMerItemName(String subMerItemName) {
        this.subMerItemName = subMerItemName;
    }

    /**
     * Sets new 店铺名称.
     *
     * @param storeName New value of 店铺名称.
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Gets 促销结束时间-时间戳.
     *
     * @return Value of 促销结束时间-时间戳.
     */
    public Long getPromEndTime() {

        return promEndTime;
    }

    /**
     * Gets 品牌id.
     *
     * @return Value of 品牌id.
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * Gets 企业id.
     *
     * @return Value of 企业id.
     */
    public String getEntId() {
        return entId;
    }

    /**
     * Gets 企业名称.
     *
     * @return Value of 企业名称.
     */
    public String getEntName() {
        return entName;
    }

    /**
     * Gets 品牌名称.
     *
     * @return Value of 品牌名称.
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets new 促销结束时间-时间戳.
     *
     * @param promEndTime New value of 促销结束时间-时间戳.
     */
    public void setPromEndTime(Long promEndTime) {
        this.promEndTime = promEndTime;
    }

    /**
     * Gets 商品基本属性集合.
     *
     * @return Value of 商品基本属性集合.
     */
    public Map<String, List<String>> getFilterQuerySpuAttrMap() {
        return filterQuerySpuAttrMap;
    }

    /**
     * Sets new SKU市场价格.
     *
     * @param marketPrice New value of SKU市场价格.
     */
    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * Gets 促销开始时间-时间戳.
     *
     * @return Value of 促销开始时间-时间戳.
     */
    public Long getPromStartTime() {

        return promStartTime;
    }

    /**
     * Sets new 促销开始时间-时间戳.
     *
     * @param promStartTime New value of 促销开始时间-时间戳.
     */
    public void setPromStartTime(Long promStartTime) {
        this.promStartTime = promStartTime;
    }

    /**
     * Sets new 关键字.
     *
     * @param keyword New value of 关键字.
     */
    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    /**
     * Sets new 商品全称.
     *
     * @param prodName New value of 商品全称.
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * Sets new 商品主图片.
     *
     * @param skuImg New value of 商品主图片.
     */
    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    /**
     * Gets 展示分类code.
     *
     * @return Value of 展示分类code.
     */
    public List<String> getCateIdArray() {
        return cateIdArray;
    }



    /**
     * Sets new 店铺展示分类名字.
     *
     * @param storeCateNameArray New value of 店铺展示分类名字.
     */
    public void setStoreCateNameArray(List<String> storeCateNameArray) {
        this.storeCateNameArray = storeCateNameArray;
    }

    /**
     * Sets new 店铺id.
     *
     * @param storeId New value of 店铺id.
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * Gets 商品主图片.
     *
     * @return Value of 商品主图片.
     */
    public String getSkuImg() {
        return skuImg;
    }

    /**
     * Sets new 好评率.
     *
     * @param bestComm New value of 好评率.
     */
    public void setBestComm(String bestComm) {
        this.bestComm = bestComm;
    }

    /**
     * Gets prodId.
     *
     * @return Value of prodId.
     */
    public String getProdId() {
        return prodId;
    }

    /**
     * Sets new 主展示分类的一级分类code.
     *
     * @param aCate New value of 主展示分类的一级分类code.
     */
    public void setACate(String aCate) {
        this.aCate = aCate;
    }

    /**
     * Sets new 主展示分类code.
     *
     * @param cateId New value of 主展示分类code.
     */
    public void setCateId(String cateId) {
        this.cateId = cateId;
    }



    /**
     * Gets 商品全称.
     *
     * @return Value of 商品全称.
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * Sets new 展示分类名字.
     *
     * @param cateNameArray New value of 展示分类名字.
     */
    public void setCateNameArray(List<String> cateNameArray) {
        this.cateNameArray = cateNameArray;
    }

    /**
     * Sets new 促销id.
     *
     * @param promotionId New value of 促销id.
     */
    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * Gets 商品基本属性集合.
     *
     * @return Value of 商品基本属性集合.
     */
    public List<String> getFilterQuerySpuAttrList() {
        return filterQuerySpuAttrList;
    }



    /**
     * Sets new 库存.
     *
     * @param stock New value of 库存.
     */
    public void setStock(Long stock) {
        this.stock = stock;
    }

    /**
     * Sets new 品牌id.
     *
     * @param brandId New value of 品牌id.
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    /**
     * Gets 上架时间.
     *
     * @return Value of 上架时间.
     */
    public Date getOnSaleTime() {
        return onSaleTime;
    }

    /**
     * Sets new 商品售卖标题.
     *
     * @param merItemName New value of 商品售卖标题.
     */
    public void setMerItemName(String merItemName) {
        this.merItemName = merItemName;
    }

    /**
     * Sets new 上架时间.
     *
     * @param onSaleTime New value of 上架时间.
     */
    public void setOnSaleTime(Date onSaleTime) {
        this.onSaleTime = onSaleTime;
    }

    /**
     * Gets 店铺展示分类code.
     *
     * @return Value of 店铺展示分类code.
     */
    public List<String> getStoreCateIdArray() {
        return storeCateIdArray;
    }

    /**
     * Sets new 商品基本属性集合.
     *
     * @param filterQuerySpuAttrList New value of 商品基本属性集合.
     */
    public void setFilterQuerySpuAttrList(List<String> filterQuerySpuAttrList) {
        this.filterQuerySpuAttrList = filterQuerySpuAttrList;
    }

    /**
     * Sets new 商品价格.
     *
     * @param price New value of 商品价格.
     */
    public void setPrice(Float price) {
        this.price = price;
    }


    /**
     * javaPo转换solrPo,将属性集合进行合并
     * @param po    javaPo
     * @param solrProductIndex  solrPo
     * @return  转换后的solrPo
     */
    public static SolrProductIndex convertPoToIndex(ProductSolrPo po, SolrProductIndex solrProductIndex){
        List<String> list=null;
        //将map集合中进行合并,实际上是map中list的数据进行合并
        if(po.getFilterQueryItemSpecMap()!=null && po.getFilterQueryItemSpecMap().size()>0){
            for (Map.Entry<String, String> entry : po.getFilterQueryItemSpecMap().entrySet()) {

                if(po.getFilterQuerySpuAttrMap().get(entry.getKey())!=null){
                    po.getFilterQuerySpuAttrMap().get(entry.getKey()).add(entry.getValue());
                    po.getFilterQuerySpuAttrMap().put(entry.getKey(),removingDuplicate(po.getFilterQuerySpuAttrMap().get(entry.getKey())));
                }else{
                    list=new ArrayList<>();
                    list.add(entry.getValue());
                    po.getFilterQuerySpuAttrMap().put(entry.getKey(),removingDuplicate(list));
                }

            }
        }
        //list集合去重,减少体积
        po.setFilterQuerySpuAttrList(removingDuplicate(po.getFilterQueryItemSpecList(),po.getFilterQuerySpuAttrList()));
       // BeanUtils.copyProperties(po, solrProductIndex);

        return solrProductIndex;
    }

    /**
     * 集合去重
     * @param lists 需要去重的 一个/多个 集合
     * @return  去重后的集合
     */
    public static List<String> removingDuplicate(List<String> ...lists){
        Set<String> set=new LinkedHashSet<>();
        List<String> strList=new LinkedList<>();
        for(List<String> list:lists){
            for(String str:list){
                set.add(str);
            }
        }
        for(String str:set){
            strList.add(str);
        }
        return strList;
    }

    /**
     * 转换javaPo与solrPo集合
     * @param solrPos   solrPo集合
     * @param pos   javaPo集合
     * @return  转换后的solrPo集合
     */
    public static List<SolrProductIndex> converPosToIndexs(List<SolrProductIndex> solrPos, List<ProductSolrPo> pos){
        SolrProductIndex solrProductIndex=null;
        for(ProductSolrPo po:pos){
            solrProductIndex=new SolrProductIndex();
            solrProductIndex=convertPoToIndex(po,solrProductIndex);
            solrPos.add(solrProductIndex);
        }
        return solrPos;
    }

    /**
     * Gets 商品小图片.
     *
     * @return Value of 商品小图片.
     */
    public List<String> getImgs() {
        return imgs;
    }

    /**
     * Sets new 商品小图片.
     *
     * @param imgs New value of 商品小图片.
     */
    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
