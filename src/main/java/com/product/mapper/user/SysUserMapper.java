package com.product.mapper.user;


import com.fengyong.core.mybatis.MybatisCRUDMapper;
import com.fengyong.core.mybatis.MybatisPagingMapper;
import com.product.po.user.base.BaseSysUserPo;

/**
 * SysUser 数据持久层接口定义.
 *
 * @author wzy
 *         Created by wzy on 12/4/2015.
 * @version 1.0
 * @since 1.0
 */
public interface SysUserMapper extends MybatisCRUDMapper<BaseSysUserPo>,MybatisPagingMapper<BaseSysUserPo> {
}