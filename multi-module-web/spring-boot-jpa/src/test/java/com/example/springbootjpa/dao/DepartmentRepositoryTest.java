package com.example.springbootjpa.dao;

import com.alibaba.fastjson.JSON;
import com.example.springbootjpa.model.Department;
import com.example.springbootjpa.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author CREATED BY L.C.Y on 2019-2-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    @Test
    public void jpaTest() {
        // 更新时也是用Save方法，但是需要指定更新数据的主键ID,如果主键不存在，则新增数据
        departmentRepository.save(new Department().setId(8L).setName("科技8部").setDescription("专注技术").setLevelId(5));
        System.out.println(departmentRepository.findAll());
        System.out.println(departmentRepository.findById(10L).isPresent() ? departmentRepository.findById(10L).get() : null);

        // 是否存在
        System.out.println(departmentRepository.exists(Example.of(new Department().setName("科技3部"))));
        System.out.println(departmentRepository.existsById(1L));

        // 分页排序, 是从0开始，MDZZ
        Pageable pageable = PageRequest.of(0, 10, new Sort(Sort.Direction.DESC, "id"));
        System.out.println(JSON.toJSONString(departmentRepository.findAll(pageable).getContent(), true));
    }

    @Test
    public void jpaServiceTest() {
        System.out.println(departmentService.findAll(1, 10));
    }

}