package com.example.mq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.mq.entity.MessageEntity;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author CREATED BY L.C.Y on 2019-3-4
 */
@RestController
@RequestMapping
public class RocketMqSendController {

    @PostMapping("/message")
    public void sendMqFromRocketMq() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("rocket");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        for (int i = 0; i < 5; i ++) {
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setMessage("message from rocket :" + i).setPurchase(new BigDecimal("5.33"));

            Message message = new Message("TopicTest", "TagA", JSON.toJSONString(messageEntity).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            System.out.printf("%s%n", result);

        }
        producer.shutdown();
    }
}
