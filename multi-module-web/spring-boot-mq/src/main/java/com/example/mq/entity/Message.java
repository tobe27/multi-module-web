package com.example.mq.entity;

import lombok.Data;

@Data
public class Message {
    private String id;
    private String message;
    private Long sendAt;
}
