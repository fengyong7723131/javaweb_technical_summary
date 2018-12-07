package com.product.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/8/16 下午6:46.
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext-*.xml"});
        context.start();

        System.out.println("===========================服务启动成功！===============================");
        System.out.println("任意键退出服务");
        System.in.read();
        context.stop();
    }
}
