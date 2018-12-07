package com.product.aop;

import com.fengyong.base.rely.ResultPoBean;
import com.product.po.user.SysUserPo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/7/27 下午3:53.
 */
public class AdviceCacheTest {
    public void cache() {
        System.out.println("我缓存了.......");
    }

    public void before(JoinPoint jp) {
        Object[] objs = jp.getArgs();
        System.out.println("我是前置通知:===before...参数的个数是:===" + objs.length);
    }

    public void after() {
        System.out.println("我是最终通知,异常也会继续执行:===after..");
    }

    public void afterReturning(Object obj) {
        System.out.println("我是后置通知,可以获取获取并且修改返回值:===after.." + obj.toString());
    }

    public void afterThorwing(Exception e) {
        System.out.println("我是异常通知,可以获取获取并且修改返回值:===after.." + e.getMessage());
    }

    public Object around(ProceedingJoinPoint pjp) {
        Object obj = new Object();
        try {
            System.out.println("我是环绕通知方法执行前...");
            obj = pjp.proceed(pjp.getArgs());
            System.out.println("我是环绕通知方法执行后...返回值是:" + obj.toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

    public void shw() {
        ResultPoBean<SysUserPo> resultPoBean = new ResultPoBean<SysUserPo>();

    }
}
