package com.example.activiti.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by L.C.Y on 2018-11-29
 */

@Configuration
public class ActivitiConfiguration {

    private static final String bpmnSource = "processes/leave.bpmn20.xml";
    private static final String pngSource = "processes/leave.png";


    @Bean
    public static Deployment deploy() {
        System.out.println("发布");
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        return processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource(bpmnSource)
                .addClasspathResource(pngSource)
                .deploy();

    }

}
