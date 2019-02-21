package com.example.springbootjpa.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部门实体类，JPA自动生成数据库表
 * @author CREATED BY L.C.Y on 2019-2-20
 */

@Table(name = "jpa_department") // 生成的数据库表名
@Entity
@Data
@Accessors(chain = true)
public class Department implements Serializable {
    private static final long serialVersionUID = 8515570853326699530L;

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true, length = 20)
    String name;

    @Column(nullable = false, length = 100)
    String description;

    @Column(length = 10)
    Integer levelId;

    @Transient  // 不会生成数据库字段
    String notInTable;

}
