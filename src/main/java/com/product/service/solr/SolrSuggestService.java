package com.product.service.solr;

import com.product.po.solr.SolrSuggestIndex;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 17/1/4 上午11:04.
 */
public interface SolrSuggestService extends SolrCrudRepository<SolrSuggestIndex,String> {

}
