package com.example.service.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class RoleDO implements Serializable {
    private static final long serialVersionUID = 3823400092118763750L;
    private Long id;

    private String roleEn;

    private String roleCh;

    private Long createdAt;

    private Long updatedAt;

    private List<PermissionDO> perms;

}