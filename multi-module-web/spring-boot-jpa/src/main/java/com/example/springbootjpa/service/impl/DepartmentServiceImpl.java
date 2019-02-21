package com.example.springbootjpa.service.impl;

import com.example.springbootjpa.dao.DepartmentRepository;
import com.example.springbootjpa.model.Department;
import com.example.springbootjpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CREATED BY L.C.Y on 2019-2-20
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void saveAll(List<Department> departments) {
        departmentRepository.saveAll(departments);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        departmentRepository.delete(new Department().setName(name));
    }

    @Override
    public Department updateById(Department department) {
        return departmentRepository.save(department);
    }


    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).isPresent() ? departmentRepository.findById(id).get() : null;
    }

    @Override
    public List<Department> findAll(Integer pageNum, Integer pageSize) {
        return departmentRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).getContent();
    }
}
