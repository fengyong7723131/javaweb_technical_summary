package com.test.spring;

import com.product.freemwork.amq.SimpleJmsTemplate;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 类描述:receiver测试类
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/8/8 下午5:28.
 */
public class ActiveMqReceiver extends BaseTest {
    @Autowired
    private SimpleJmsTemplate receiverJmsTemplate;
    @Autowired
    private ActiveMQQueue activeMQQueue;

    /**
     * 如果session事物设置为true,receiver直接将sessioin进行commit,
     * <p>
     * 如果设置为false,receiver方法会直接判断进行消息确认,无法做到手动的消息确认,所以一旦发生异常,这条消息不会回到消息队列中
     * <p>
     * session的提交可以认为是消息确认收到
     *
     * @throws JMSException
     */
    @Test
    public void recerver() throws JMSException {
        int i = 1;
        int j = 0;
        String eq = null;
        while (true) {
            i++;
            TextMessage message = (TextMessage) receiverJmsTemplate.receive(activeMQQueue);
            if (null != message) {
                String messageText = message.getText();
                System.out.println("收到消息==================" + messageText);
                if (messageText.equals("我是第2个")) {
                    try {
                        throw new RuntimeException("Exception");
                    } catch (Exception e) {
                        System.out.println("第" + j + "次接收");
                        j++;
                        receiverJmsTemplate.getSessionToUse().recover();
                    }
                }
                receiverJmsTemplate.msgAckAndcloseSession(message);
            } else {
                break;
            }
        }
    }
}
