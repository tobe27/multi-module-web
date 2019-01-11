package com.example.activiti.config;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ActivitiConfigurationTest {

    @Test
    public void test() {
        new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.1.137:3306/workflow?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false")
                .setJdbcUsername("root")
                .setJdbcPassword("123456")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .buildProcessEngine();
    }


}