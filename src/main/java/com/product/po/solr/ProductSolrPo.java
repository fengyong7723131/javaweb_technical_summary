package com.product.po.solr;


import com.fengyong.base.beans.Po;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品与solr关联的实体对象
 *
 * @author zkk
 * @version 1.0
 * @since 1.0
 * Created by zkk on 2016/4/26 9:58.
 */
public class ProductSolrPo extends Po {
    
    /**
     * prodId
     */
    private String prodId;

    /**
     * 商品全称
     */
    private String prodName;

    /**
     * 主展示分类的一级分类code
     */
    private String aCate;

    /**
     * 主展示分类code
     */
    private String cateId;

    /**
     * 展示分类code
     */
    private List<String> cateIdArray;

    /**
     * 展示分类名字
     */
    private List<String> cateNameArray;

    /**
     * 店铺主展示分类code
     */
    private String storeCateId;

    /**
     * 店铺展示分类code
     */
    private List<String> storeCateIdArray;

    /**
     * 店铺展示分类名字
     */
    private List<String> storeCateNameArray;

    /**
     * 关键字
     */
    private String keyword;
    
    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 企业id
     */
    private String entId;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 店铺id
     */
    private String storeId;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 生产厂商
     */
    private String prodMfrs;
    
    /**
     * 评论数量
     */
    private String commCount;

    /**
     * 评论星级
     */
    private String commStar;

    /**
     * 好评率
     */
    private String bestComm;

    /**
     * itemId
     */
    private String itemId;

    /**
     * 商品价格
     */
    private Float price;

    /**
     * SKU市场价格
     */
    private Float marketPrice;

    /**
     * 商品主图片
     */
    private String skuImg;

    /**
     * 商品小图片
     */
    private List<String> imgs;

    /**
     * 商品售卖标题
     */
    private String merItemName;

    /**
     * 商品售卖子标题
     */
    private String subMerItemName;

    /**
     * 销量
     */
    private Long itemSales;

    /**
     * 库存
     */
    private Long stock;

    /**
     * 上架时间
     */
    private Date onSaleTime;

    /**
     * 促销id
     */
    private String promotionId;
    
    /**
     * 促销类型
     */
    private Integer promotionType;
    
    /**
     * 促销开始时间-时间戳
     */
    private Long promStartTime;
    
    /**
     * 促销结束时间-时间戳
     */
    private Long promEndTime;

    /**
     * 商品基本属性集合
     */
    private Map<String, List<String>> filterQuerySpuAttrMap;

    /**
     * 商品基本属性集合
     */
    private List<String> filterQuerySpuAttrList;




    /**
     * 商品品规属性集合
     */
    private Map<String, String> filterQueryItemSpecMap;

    /**
     * 商品品规属性集合
     */
    private List<String> filterQueryItemSpecList;

    /**
     * Sets new SKU市场价格.
     *
     * @param marketPrice New value of SKU市场价格.
     */
    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
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
     * Sets new 商品售卖子标题.
     *
     * @param subMerItemName New value of 商品售卖子标题.
     */
    public void setSubMerItemName(String subMerItemName) {
        this.subMerItemName = subMerItemName;
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
     * Sets new 商品基本属性集合.
     *
     * @param filterQuerySpuAttrMap New value of 商品基本属性集合.
     */
    public void setFilterQuerySpuAttrMap(Map<String, List<String>> filterQuerySpuAttrMap) {
        this.filterQuerySpuAttrMap = filterQuerySpuAttrMap;
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
     * Gets 上架时间.
     *
     * @return Value of 上架时间.
     */
    public Date getOnSaleTime() {
        return onSaleTime;
    }

    /**
     * Gets 评论数量.
     *
     * @return Value of 评论数量.
     */
    public String getCommCount() {
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
     * Gets 销量.
     *
     * @return Value of 销量.
     */
    public Long getItemSales() {
        return itemSales;
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
     * Sets new 关键字.
     *
     * @param keyword New value of 关键字.
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Sets new 评论数量.
     *
     * @param commCount New value of 评论数量.
     */
    public void setCommCount(String commCount) {
        this.commCount = commCount;
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
     * Gets 好评率.
     *
     * @return Value of 好评率.
     */
    public String getBestComm() {
        return bestComm;
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
     * Gets itemId.
     *
     * @return Value of itemId.
     */
    public String getItemId() {
        return itemId;
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
     * Sets new 商品主图片.
     *
     * @param skuImg New value of 商品主图片.
     */
    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
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
     * Sets new 店铺展示分类code.
     *
     * @param storeCateIdArray New value of 店铺展示分类code.
     */
    public void setStoreCateIdArray(List<String> storeCateIdArray) {
        this.storeCateIdArray = storeCateIdArray;
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
     * Gets 促销类型.
     *
     * @return Value of 促销类型.
     */
    public Integer getPromotionType() {
        return promotionType;
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
     * Sets new 库存.
     *
     * @param stock New value of 库存.
     */
    public void setStock(Long stock) {
        this.stock = stock;
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
     * Gets 展示分类名字.
     *
     * @return Value of 展示分类名字.
     */
    public List<String> getCateNameArray() {
        return cateNameArray;
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
     * Gets 店铺主展示分类code.
     *
     * @return Value of 店铺主展示分类code.
     */
    public String getStoreCateId() {
        return storeCateId;
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
     * Gets 促销结束时间-时间戳.
     *
     * @return Value of 促销结束时间-时间戳.
     */
    public Long getPromEndTime() {
        if(this.promEndTime==null){
            this.promEndTime=Long.valueOf(0);
        }
        return promEndTime;
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
     * Gets 商品主图片.
     *
     * @return Value of 商品主图片.
     */
    public String getSkuImg() {
        return skuImg;
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
     * Sets new 主展示分类code.
     *
     * @param cateId New value of 主展示分类code.
     */
    public void setCateId(String cateId) {
        this.cateId = cateId;
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
     * Gets 促销id.
     *
     * @return Value of 促销id.
     */
    public String getPromotionId() {
        return promotionId;
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
     * Gets 商品售卖子标题.
     *
     * @return Value of 商品售卖子标题.
     */
    public String getSubMerItemName() {
        return subMerItemName;
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
     * Sets new 商品售卖标题.
     *
     * @param merItemName New value of 商品售卖标题.
     */
    public void setMerItemName(String merItemName) {
        this.merItemName = merItemName;
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
     * Gets 企业名称.
     *
     * @return Value of 企业名称.
     */
    public String getEntName() {
        return entName;
    }

    /**
     * Gets 商品品规属性集合.
     *
     * @return Value of 商品品规属性集合.
     */
    public List<String> getFilterQueryItemSpecList() {
        return filterQueryItemSpecList;
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
     * Gets 库存.
     *
     * @return Value of 库存.
     */
    public Long getStock() {
        return stock;
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
     * Sets new 商品品规属性集合.
     *
     * @param filterQueryItemSpecMap New value of 商品品规属性集合.
     */
    public void setFilterQueryItemSpecMap(Map<String, String> filterQueryItemSpecMap) {
        this.filterQueryItemSpecMap = filterQueryItemSpecMap;
    }

    /**
     * Gets 促销开始时间-时间戳.
     *
     * @return Value of 促销开始时间-时间戳.
     */
    public Long getPromStartTime() {
        if(this.promStartTime==null){
            this.promStartTime=Long.valueOf(0);
        }
        return promStartTime;
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
     * Gets 店铺名称.
     *
     * @return Value of 店铺名称.
     */
    public String getStoreName() {
        return storeName;
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
     * Sets new 店铺名称.
     *
     * @param storeName New value of 店铺名称.
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
     * Sets new 促销结束时间-时间戳.
     *
     * @param promEndTime New value of 促销结束时间-时间戳.
     */
    public void setPromEndTime(Long promEndTime) {
        this.promEndTime = promEndTime;
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
     * Sets new 好评率.
     *
     * @param bestComm New value of 好评率.
     */
    public void setBestComm(String bestComm) {
        this.bestComm = bestComm;
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
     * Sets new 品牌id.
     *
     * @param brandId New value of 品牌id.
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
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
     * Sets new 店铺id.
     *
     * @param storeId New value of 店铺id.
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * Gets 商品品规属性集合.
     *
     * @return Value of 商品品规属性集合.
     */
    public Map<String, String> getFilterQueryItemSpecMap() {
        return filterQueryItemSpecMap;
    }

    /**
     * Gets 关键字.
     *
     * @return Value of 关键字.
     */
    public String getKeyword() {
        return keyword;
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
     * Sets new 促销开始时间-时间戳.
     *
     * @param promStartTime New value of 促销开始时间-时间戳.
     */
    public void setPromStartTime(Long promStartTime) {
        this.promStartTime = promStartTime;
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
     * Gets 商品基本属性集合.
     *
     * @return Value of 商品基本属性集合.
     */
    public Map<String, List<String>> getFilterQuerySpuAttrMap() {
        return filterQuerySpuAttrMap;
    }

    /**
     * Sets new 商品品规属性集合.
     *
     * @param filterQueryItemSpecList New value of 商品品规属性集合.
     */
    public void setFilterQueryItemSpecList(List<String> filterQueryItemSpecList) {
        this.filterQueryItemSpecList = filterQueryItemSpecList;
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
     * Sets new 企业id.
     *
     * @param entId New value of 企业id.
     */
    public void setEntId(String entId) {
        this.entId = entId;
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
     * Gets 展示分类code.
     *
     * @return Value of 展示分类code.
     */
    public List<String> getCateIdArray() {
        return cateIdArray;
    }

    /**
     * Sets new 商品小图片.
     *
     * @param imgs New value of 商品小图片.
     */
    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    /**
     * Gets 商品小图片.
     *
     * @return Value of 商品小图片.
     */
    public List<String> getImgs() {
        return imgs;
    }
}
