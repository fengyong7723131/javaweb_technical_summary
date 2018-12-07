package com.product.service.solr;

import com.fengyong.base.beans.page.QueryBean;
import com.fengyong.base.rely.ResultPoBean;
import com.product.po.solr.SolrProductIndex;
import com.product.po.solr.SolrResultPo;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Collection;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 17/1/4 上午11:04.
 */
public interface SolrProductService extends SolrCrudRepository<SolrProductIndex,String> {
    /**
     * solr主查询方法
     * @param queryBean 查询参数
     * @return  封装result数据
     */
    ResultPoBean<SolrResultPo> querySolrProduct(QueryBean queryBean);

    /**
     * 添加索引,无提交
     * @param beans
     * @return
     */
    UpdateResponse saveBeans(Collection<?> beans);

}
