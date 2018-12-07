package com.test.mq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/11/11 下午2:31.
 */
public class JmsProducer {
    String url = "tcp://localhost:61616";
    String username = "admin";
    String password = "admin";

    @Test
    public void jmsSender(){
        Connection connection = null;
        Session session = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username,password,url);
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Destination queue = session.createQueue("First");
            //发送
            MessageProducer producer = session.createProducer(queue);
            Message message = session.createTextMessage("message1");
            producer.send(message);
            //接收
            MessageConsumer consumer = session.createConsumer(queue);
            Message receiveMessage = consumer.receive();
            System.out.print(((TextMessage)receiveMessage).getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
