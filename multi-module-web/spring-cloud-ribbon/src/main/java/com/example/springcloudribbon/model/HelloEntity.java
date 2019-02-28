package com.example.springcloudribbon.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author CREATED BY L.C.Y on 2019-2-28
 */
@Data
@Accessors(chain = true)
public class HelloEntity {
    String name;
    String message;
}
