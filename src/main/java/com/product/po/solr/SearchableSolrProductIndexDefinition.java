package com.product.po.solr;

/**
 * 类描述:Po类常量,用于规定与schema中字段的统一性与常量定义
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/5/3 下午5:22.
 */
public interface SearchableSolrProductIndexDefinition {
    String PRODID_FIELD_NAME = "prodId";
    String PRODNAME_FIELD_NAME = "prodName";
    String ACATE_FIELD_NAME = "aCate";
    String CATEID_FIELD_NAME = "cateId";
    String CATEIDARRAY_FIELD_NAME = "cateIdArray";
    String CATENAMEARRAY_FIELD_NAME = "cateNameArray";
    String STORECATEID_FIELD_NAME = "storeCateId";
    String STORECATEIDARRAY_FIELD_NAME = "storeCateIdArray";
    String STORECATENAMEARRAY_FIELD_NAME = "storeCateNameArray";
    String KEYWORD_FIELD_NAME = "keyword";
    String BRANDID_FIELD_NAME = "brandId";
    String BRANDNAME_FIELD_NAME = "brandName";
    String ENTID_FIELD_NAME = "entId";
    String ENTNAME_FIELD_NAME = "entName";
    String STOREID_FIELD_NAME = "storeId";
    String STORENAME_FIELD_NAME = "storeName";
    String PRODMFRS_FIELD_NAME = "prodMfrs";
    String COMMCOUNT_FIELD_NAME = "commCount";
    String COMMSTAR_FIELD_NAME = "commStar";
    String BESTCOMM_FIELD_NAME = "bestComm";
    String ITEMID_FIELD_NAME = "id";
    String PRICE_FIELD_NAME = "price";
    String MARKETPRICE_FIELD_NAME = "marketPrice";
    String SKUIMG_FIELD_NAME = "skuImg";
    String IMGS = "imgs";
    String MERITEMNAME_FIELD_NAME = "merItemName";
    String SUBMERITEMNAME_FIELD_NAME = "subMerItemName";
    String ITEMSALES_FIELD_NAME = "itemSales";
    String STOCK_FIELD_NAME = "stock";
    String ONSALETIME_FIELD_NAME = "onSaleTime";
    String PROMOTIONID_FIELD_NAME = "promotionId";
    String PROMOTIONTYPE_FIELD_NAME = "promotionType";
    String PROMSTARTTIME_FIELD_NAME = "promStartTime";
    String PROMENDTIME_FIELD_NAME = "promEndTime";
    String FILTERQUERYITEMSPECMAP_FIELD_NAME = "filterQueryItem_*";
    String FILTERQUERYITEMSPECLIST_FIELD_NAME = "filterQueryItemList";
}
