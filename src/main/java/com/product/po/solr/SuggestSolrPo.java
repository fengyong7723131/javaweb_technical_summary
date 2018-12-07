package com.product.po.solr;


import com.fengyong.base.beans.Po;

/**
 * solr提示词
 *
 * @author zkk
 * @version 1.0
 * @since 1.0
 * Created by zkk on 2016/5/3 14:18.
 */
public class SuggestSolrPo extends Po {

    /**
     * uuid主键
     */
    private String id;

    /**
     * 商品的SKU
     */
    private String itemId;

    /**
     * 关键词名字，用做solr索引的主键
     */
    private String keyword;

    /**
     * 完整的拼音拼写
     */
    private String fullPinyin;

    /**
     * 拼音数组
     */
    private String[] pinyin;

    /**
     * 拼音缩写数组
     */
    private String[] abbre;

    /**
     * 检索次数
     */
    private Double kwfreq;

    /**
     * 企业id
     */
    private Long entId;

    /**
     * 店铺id
     */
    private Long storeId;

    /**
     * 如果关键词为店铺类目,cateId不为空
     */
    private String cateId;

    /**
     * 关键词所属对象所关联到的店铺类目数组
     */
    private String[] cateIdArray;

    /**
     * 无参数的构造方法
     */
    public SuggestSolrPo() {
    }

    /**
     * 构造方法，用于企业id，店铺id，分类code
     * @param entId 企业id
     * @param storeId 店铺id
     * @param cateIdArray 店铺展示分类code
     */
    public SuggestSolrPo(Long entId, Long storeId, String[] cateIdArray) {
        this.entId = entId;
        this.storeId = storeId;
        this.cateIdArray = cateIdArray;
    }

    /**
     * Gets 关键词所属对象所关联到的类目数组.
     *
     * @return Value of 关键词所属对象所关联到的类目数组.
     */
    public String[] getCateIdArray() {
        return cateIdArray;
    }

    /**
     * Sets new 检索次数.
     *
     * @param kwfreq New value of 检索次数.
     */
    public void setKwfreq(Double kwfreq) {
        this.kwfreq = kwfreq;
    }

    /**
     * Sets new 拼音数组.
     *
     * @param pinyin New value of 拼音数组.
     */
    public void setPinyin(String[] pinyin) {
        this.pinyin = pinyin;
    }

    /**
     * Sets new 拼音缩写数组.
     *
     * @param abbre New value of 拼音缩写数组.
     */
    public void setAbbre(String[] abbre) {
        this.abbre = abbre;
    }

    /**
     * Sets new 如果关键词为类目,cateId不为空.
     *
     * @param cateId New value of 如果关键词为类目,cateId不为空.
     */
    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    /**
     * Gets 企业id.
     *
     * @return Value of 企业id.
     */
    public Long getEntId() {
        return entId;
    }

    /**
     * Sets new 企业id.
     *
     * @param entId New value of 企业id.
     */
    public void setEntId(Long entId) {
        this.entId = entId;
    }

    /**
     * Sets new 关键词所属对象所关联到的类目数组.
     *
     * @param cateIdArray New value of 关键词所属对象所关联到的类目数组.
     */
    public void setCateIdArray(String[] cateIdArray) {
        this.cateIdArray = cateIdArray;
    }

    /**
     * Gets 如果关键词为类目,cateId不为空.
     *
     * @return Value of 如果关键词为类目,cateId不为空.
     */
    public String getCateId() {
        return cateId;
    }

    /**
     * Gets 店铺id.
     *
     * @return Value of 店铺id.
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * Gets 拼音缩写数组.
     *
     * @return Value of 拼音缩写数组.
     */
    public String[] getAbbre() {
        return abbre;
    }

    /**
     * Sets new 关键词名字，用做solr索引的主键.
     *
     * @param keyword New value of 关键词名字，用做solr索引的主键.
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Gets 拼音数组.
     *
     * @return Value of 拼音数组.
     */
    public String[] getPinyin() {
        return pinyin;
    }

    /**
     * Gets 检索次数.
     *
     * @return Value of 检索次数.
     */
    public Double getKwfreq() {
        return kwfreq;
    }

    /**
     * Gets 完整的拼音拼写.
     *
     * @return Value of 完整的拼音拼写.
     */
    public String getFullPinyin() {
        return fullPinyin;
    }

    /**
     * Sets new uuid主键.
     *
     * @param id New value of uuid主键.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets new 店铺id.
     *
     * @param storeId New value of 店铺id.
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * Gets uuid主键.
     *
     * @return Value of uuid主键.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets 关键词名字，用做solr索引的主键.
     *
     * @return Value of 关键词名字，用做solr索引的主键.
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets new 完整的拼音拼写.
     *
     * @param fullPinyin New value of 完整的拼音拼写.
     */
    public void setFullPinyin(String fullPinyin) {
        this.fullPinyin = fullPinyin;
    }


    /**
     * Gets 商品的SKU.
     *
     * @return Value of 商品的SKU.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets new 商品的SKU.
     *
     * @param itemId New value of 商品的SKU.
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
