package com.product.core.solr;

import org.springframework.data.solr.core.SolrTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/5/6 下午3:15.
 */
public interface SolrConstants {
    /**
     * 商品数据 solr服务地址
     */
    String BASE_URL_MERCHANT = "http://localhost:8080/solr";
    /**
     * 商品数据 solr服务索引
     */
    String PRODUCT_COLLECTION = "core0";
    /**
     * 提示词 solr服务地址
     */
    String BASE_URL_SUGGEST = "http://localhost:8080/solr";
    /**
     * 提示词 solr服务地址
     */
    String SUGGEST_COLLECTION = "core1";

    /**
     * 主商品
     */
    String MERCHANT = "merchant";
    /**
     * 提示词
     */
    String SUGGEST = "suggest";

    /**
     * 关键字查询字段
     */
    String Q_FIELD = "keyword";

    /**
     * 过滤查询字段前缀
     */
    String FILTERQUERYITEM = "filterQueryItem_";

    /**
     * 排序规则
     */
    String SORT_ASC = "asc";
    String SORT_DESC = "desc";

    /**
     * 查询规则
     */
    String OR = " OR ";
    String AND = " AND ";
    //==================================分隔符====================================

    String SPASE = " ";
    String FENHAO = ";";
    String XIAHUAXIAN = "_";
    String MAOHAO = ":";
    String DOUHAO = ",";
    //==================================分隔符====================================

    String WILDCARD= "*";

    Map<String, SolrTemplate> SOLR_SERVER_CACHE = new ConcurrentHashMap<>();
}
