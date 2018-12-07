package com.product.msg;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/8/4 下午7:30.
 */
public class MyMessageListener implements MessageListener {


    /**
     * 使用poolConnection测试结果:当队列里面有数据时,发送者发数据时,触发这里的监听器,消费者会接受到队列里的加上发送者发送到队列里的所有数据
     * 消费出现异常,不影响发送者发送数据到队列,但是发送者再次发送时候总会有一些数据丢在队列里面导致没有接收到
     *
     * 建议使用原生的Connection.建议设置session事物为true,true的时候自动确认和异常消息回到队列
     *
     * 如果session事物为false,在抛出异常前进行消息确认,那么只要确认,就会被推送消息,所以不管有没有异常,消息都推送过来,不会留在队列里
     * session事物设置为false,将消息确认放在可能发生异常的下方,和session事物为true的效果一样,但是这样可以手动控制消息确认
     *
     * @param messgae
     */
    int i=1;
    public synchronized void onMessage(Message messgae) {
        i++;
        if(messgae instanceof TextMessage) {
            System.out.print("-------------------------------");
            TextMessage textMessage = (TextMessage) messgae;
            try {
                String text = textMessage.getText();
                System.out.println("######################["+text+"]######################");
                if(i==6){
                    throw new RuntimeException("Error");
                }
                textMessage.acknowledge();

            }
            catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }


}
