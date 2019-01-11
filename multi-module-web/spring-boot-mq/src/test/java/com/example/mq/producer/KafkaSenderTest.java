package com.example.mq.producer;

import com.example.mq.consumer.KafkaReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaSenderTest {
    @Autowired
    KafkaSender sender;
    @Autowired
    KafkaReceiver receiver;
    @Test
    public void send() {
        sender.send();
        new KafkaReceiver();
        while (true) { // 使junit线程一直挂着，保证可以一直消费
            }
    }
}