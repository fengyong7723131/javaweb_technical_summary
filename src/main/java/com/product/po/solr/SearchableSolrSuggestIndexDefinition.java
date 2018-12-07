package com.product.po.solr;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/5/4 下午4:54.
 */
public interface SearchableSolrSuggestIndexDefinition {

    String ID_FIELD_NAME = "id";
    String ITEMID_FIELD_NAME = "itemId";
    String KEYWORD_FIELD_NAME = "keyword";
    String FULLPINYIN_FIELD_NAME = "fullPinyin";
    String PINYIN_FIELD_NAME = "pinyin";
    String ABBRE_FIELD_NAME = "abbre";
    String KWFREQ_FIELD_NAME = "kwfreq";
    String ENTID_FIELD_NAME = "entId";
    String STOREID_FIELD_NAME = "storeId";
    String CATEID_FIELD_NAME = "cateId";
    String CATEIDARRAY_FIELD_NAME = "cateIdArray";
    String SUGGESTSTION_FIELD_NAME = "suggestion";
}
