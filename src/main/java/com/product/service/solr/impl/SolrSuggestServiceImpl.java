package com.product.service.solr.impl;

import com.product.po.solr.SolrSuggestIndex;
import com.product.service.solr.SolrSuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import org.springframework.stereotype.Service;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 17/1/4 上午11:04.
 */
@Service
public class SolrSuggestServiceImpl extends SimpleSolrRepository<SolrSuggestIndex,String> implements SolrSuggestService {
    @Autowired(required = false)
    private SolrTemplate solrSuggestTemplate;

}
