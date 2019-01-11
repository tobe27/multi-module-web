package com.example.activiti.service;

import com.example.activiti.enums.ProcessSourceEnum;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author Created by L.C.Y on 2018-11-30
 */

public class ActivitiService {


    // 配置activiti数据库
    private static ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration()
            .setJdbcUrl("jdbc:mysql://192.168.1.137:3306/process?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false")
            .setJdbcUsername("root")
            .setJdbcPassword("123456")
            .setJdbcDriver("com.mysql.cj.jdbc.Driver")
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);

    private static ProcessEngine processEngine = configuration.buildProcessEngine();
    private static RuntimeService runtimeService = processEngine.getRuntimeService(); // 对应act_ru
    private static TaskService taskService = processEngine.getTaskService(); // 对应act_ru
    private static IdentityService identityService = processEngine.getIdentityService(); // 对应act_id
    private static RepositoryService repositoryService = processEngine.getRepositoryService(); // 对应act_re
    private static HistoryService historyService = processEngine.getHistoryService(); // 对应act_hi


    /**
     * 部署流程，向数据库导入流程引擎，存入表 act_get_bytearray
     * @param xml 流程xml
     * @param png 流程图
     * @return 部署ID
     */
    public static String deployAndGetId(ProcessSourceEnum xml, ProcessSourceEnum png) {
        Deployment deployment = repositoryService
                .createDeployment()
                .addClasspathResource(xml.getSource())
                .addClasspathResource(png.getSource())
                .deploy();
        return deployment.getId();
    }

    /**
     * 启动实例，表act_re_procdef
     * @param processId 流程xml的process元素中的id
     */
    public static String startInstance(String processId) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processId);
        return processInstance.getProcessInstanceId();
    }

    /**
     * 根据审批人获取任务
     * @param assignee 当前审批人
     * @param processId 流程xml的process元素中的id
     * @return 任务列表
     */
    public static List<Task> listTaskByAssignee(String assignee, String processId) {
        return taskService.createTaskQuery()
                .processDefinitionKey(processId)
                .taskAssignee(assignee)
                .list();
    }

    /**
     * 根据审批组获取任务
     * @param candidateGroup 当前审批组
     * @param processId 流程xml的process元素中的id
     * @return 任务列表
     */
    public static List<Task> listTaskByCandidateGroup(String candidateGroup, String processId) {
        return taskService.createTaskQuery()
                .processDefinitionKey(processId)
                .taskCandidateGroup(candidateGroup)
                .list();
    }

    /**
     * 同意流程
     * @param taskId 流程ID，来自act_ru_task
     * @param variable 用户配置排他网关的条件
     */
    public static void completeTask(String taskId, Map<String, Object> variable) {
        taskService.complete(taskId, variable);
    }

    /**
     * 删除流程
     * @param taskId 流程ID，来自act_ru_task
     */
    public static void deleteTask(String taskId) {
        taskService.deleteTask(taskId);
    }

    /**
     * 查看历史实例
     * @param processInstanceId 流程实例ID
     * @return 历史实例数据
     */
    public static List<HistoricActivityInstance> listHisInst(String processInstanceId){
        return historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId)
                .orderByHistoricActivityInstanceEndTime().desc()
                .list();
    }

}
