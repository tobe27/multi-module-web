package com.example.service.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserRoleRelationDO implements Serializable {
    private static final long serialVersionUID = 9097326670562259094L;
    private Long id;

    private Long userId;

    private Long roleId;

    private Long createdAt;

    private Long updatedAt;

}