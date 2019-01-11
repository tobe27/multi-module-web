package com.example.springbootmongodb.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDO {
    private String name;
    private String password;
    private String email;
    private String phone;
}
