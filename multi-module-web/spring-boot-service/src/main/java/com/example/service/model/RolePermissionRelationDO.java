package com.example.service.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class RolePermissionRelationDO implements Serializable {
    private static final long serialVersionUID = 2012342791306320079L;
    private Long id;

    private Long roleId;

    private Long permissionId;

    private Long createdAt;

    private Long updatedAt;

}