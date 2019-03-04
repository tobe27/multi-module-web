package com.example.mq.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author CREATED BY L.C.Y on 2019-3-4
 */
@Data
@Accessors(chain = true)
public class MessageEntity {
    private String id;
    private String message;
    private BigDecimal purchase;
    private Long sendAt;
}
