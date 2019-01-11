package com.example.service.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PermissionDO implements Serializable {
    private static final long serialVersionUID = 9103703714962407851L;
    private Long id;

    private String permissionCh;

    private String permissionUrl;

    private Long createdAt;

    private Long updatedAt;
}