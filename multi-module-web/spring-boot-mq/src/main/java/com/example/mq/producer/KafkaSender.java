package com.example.mq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
public class KafkaSender {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaSender(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send() {
        System.out.println("++++++++++++++++++++++++++ send" );
        kafkaTemplate.send("test", "message1");
    }
}
