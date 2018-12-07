package com.product.ws.user;

import com.fengyong.base.rely.ResultPoBean;
import com.product.po.user.base.BaseSysUserPo;

import javax.jws.WebService;

/**
 * 描述:
 *
 * @author fengyong
 * @date 2017/3/17.
 */
@WebService
public interface UserWebService {
    ResultPoBean<BaseSysUserPo> getUser();
}
