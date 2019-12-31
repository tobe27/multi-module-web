package com.example.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.mq.entity.MessageEntity;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author CREATED BY L.C.Y on 2019-3-4
 */
@Component
public class RocketMqConsumer {

    @PostConstruct
    public void consume() throws Exception{
        // 消费组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rocket");

        // NameServer的地址
        consumer.setNamesrvAddr("115.159.155.78:9876");

        // 订阅的主题
        consumer.subscribe("Topic", "*");
        // consumer可以设置更多的参数，包括顺序消费之类的

        // 消息监听并消费
        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            // 获取信息列表
            System.out.printf("%s Receive New Message : %s %n", Thread.currentThread().getName(), list.get(0));
            for (MessageExt messageExt : list) {
                // 将消息转换成字符串，再将字符串转换成MessageEntity
                System.out.println(JSON.toJSONString(JSONObject.parseObject(new String(messageExt.getBody()), MessageEntity.class)));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
