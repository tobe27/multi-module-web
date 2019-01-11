package com.example.activiti.service;

import com.alibaba.fastjson.JSON;
import com.example.activiti.enums.ProcessSourceEnum;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiServiceTest {

    // 配置activiti数据库
    private ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration()
            .setJdbcUrl("jdbc:mysql://192.168.1.137:3306/process?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false")
            .setJdbcUsername("root")
            .setJdbcPassword("123456")
            .setJdbcDriver("com.mysql.cj.jdbc.Driver")
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);
    private ProcessEngine processEngine = configuration.buildProcessEngine();

    //@Test
    //public void createTable() { // 创建数据库表格
    //    ProcessEngine processEngine = configuration.buildProcessEngine();
    //}

    //@Test
    //public void createTask() { // 向数据库导入流程引擎，存入表 act_get_bytearray
    //    Deployment deployment = processEngine.getRepositoryService()
    //            .createDeployment()
    //            .addClasspathResource("processes/leave.bpmn20.xml")
    //            .addClasspathResource("processes/leave.png")
    //            .deploy();
    //
    //    System.out.println("activiti部署id:"+deployment.getId());
    //}


    // 部署
    //@Test
    //public void startDeploy() {
    //    ActivitiService.deployAndGetId(ProcessSourceEnum.LEAVE_XML, ProcessSourceEnum.LEAVE_PNG);
    //}
    // 启动实例
    @Test
    public void startInstance() {
        ActivitiService.startInstance("leave");
    }

    @Test
    public void listTaskByCandidateGroup() {
        List<Task> taskList = ActivitiService.listTaskByCandidateGroup("学生组", "leave");
        for (Task task : taskList) {
            System.out.println(task.getId());
        }
    }

    // 通过或驳回通过网关type值决定，1-同意，2-驳回
    @Test
    public void completeTask() {
        Map<String, Object> variable = new HashMap<>();
        variable.put("type", 1);
        ActivitiService.completeTask("110003" , variable);
    }

    @Test
    public void deleteTask() {
        ActivitiService.deleteTask("97505");
    }

    @Test
    public void listHisInst() {
        List<HistoricActivityInstance> historicActivityInstanceList = ActivitiService.listHisInst("97501");
        if (historicActivityInstanceList == null || historicActivityInstanceList.size() == 0)  {
            System.out.println("-------------------------------------");
        } else {
            for (HistoricActivityInstance historicActivityInstance : historicActivityInstanceList) {
                System.out.println("=========================================");
                System.out.println(JSON.toJSONString(historicActivityInstance));
                System.out.println(historicActivityInstance.getTenantId());
            }
        }
    }
}