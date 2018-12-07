package com.test.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

/**
 * 类描述:sender测试类
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/8/3 下午7:45.
 */
public class ActiveMqSender extends BaseTest {
    @Autowired
    private JmsTemplate senderJmsTemplate;

    @Test
    public void activeMq(){
        for(int i = 1;i<=10;i++){
            senderJmsTemplate.convertAndSend("FirstQueue","我是第"+i+"个");

        }
        
        System.out.print("全部执行完毕!!!");
    }
}
