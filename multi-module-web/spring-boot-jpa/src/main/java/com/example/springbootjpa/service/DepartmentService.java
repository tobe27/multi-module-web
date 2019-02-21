package com.example.springbootjpa.service;

import com.example.springbootjpa.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author CREATED BY L.C.Y on 2019-2-20
 */
public interface DepartmentService {

    // 新增
    Department save(Department department);
    void saveAll(List<Department> departments);

    // 删除
    void deleteById(Long id);
    void deleteByName(String name);

    // 更新
    Department updateById(Department department);

    // 查询
    Department findById(Long id);
    List<Department> findAll(Integer pageNum, Integer pageSize);

    // 关联表查询

}
