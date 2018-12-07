package com.product.core.solr;

public interface SolrPramConstants {
    /**
     * 商品名称/关键字查询 --- 商品 环保
     */
    String Q = "q";

    /**
     * 商品属性 ---- 94_颜色:白色;95_型号:高端
     */
    String ATTR = "attr";

    /**
     * 类别id ---- 011
     */
    String CATEID = "cateId";

    /**
     * 开始价格 ---- 25
     */
    String STARTPRICE = "startPrice";

    /**
     * 结束价格 ---- 50
     */
    String ENDPRICE = "endPrice";

    /**
     * 排序 （小写的） ---- price desc
     */
    String SORT = "sort";

    /**
     * 品牌id --- 25 / null
     */
    String BRANDID = "brandId";

    /**
     * 店铺id --- 5
     */
    String STOREID = "storId";

    /**
     * 店铺搜索页里面的 类别id --- 005
     */
    String STORECATEID = "storeCateId";

    /**
     * 提示词
     */
    String ITEMID = "itemId";

    /**
     * 是否有货
     */
    String STOCK = "stock";
}