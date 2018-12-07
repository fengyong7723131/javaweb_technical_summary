package com.product.po.solr;


import com.fengyong.base.beans.Po;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/5/11 上午10:23.
 */
public class SolrResultPo extends Po {
    /**
     * 商品po集合
     */
    private List<ProductSolrPo> productSolrPoList;
    /**
     * 分组字段显示集合,用于前台显示
     */
    private Map<String,List<String>> facetFields;

    /**
     * 数据数量,分页使用
     */
    private Integer count;


    /**
     * Gets 分组字段显示集合,用于前台显示.
     *
     * @return Value of 分组字段显示集合,用于前台显示.
     */
    public Map<String, List<String>> getFacetFields() {
        return facetFields;
    }

    /**
     * Sets new 分组字段显示集合,用于前台显示.
     *
     * @param facetFields New value of 分组字段显示集合,用于前台显示.
     */
    public void setFacetFields(Map<String, List<String>> facetFields) {
        this.facetFields = facetFields;
    }

    /**
     * Gets 商品po集合.
     *
     * @return Value of 商品po集合.
     */
    public List<ProductSolrPo> getProductSolrPoList() {
        return productSolrPoList;
    }

    /**
     * Sets new 商品po集合.
     *
     * @param productSolrPoList New value of 商品po集合.
     */
    public void setProductSolrPoList(List<ProductSolrPo> productSolrPoList) {
        this.productSolrPoList = productSolrPoList;
    }

    /**
     * Gets count.
     *
     * @return Value of count.
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets new count.
     *
     * @param count New value of count.
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}
