package com.example.mq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;

/**
 * @author CREATED BY L.C.Y on 2019-3-4
 */
public class RocketMqProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("rocket");
        producer.setNamesrvAddr("115.159.155.78:9876");
        producer.start();

        for (int i = 0; i < 5; i ++) {
            Message message = new Message("Topic", "TagA", ("Hello Rocket" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            System.out.printf("%s%n", result);

        }
        producer.shutdown();
    }
}
