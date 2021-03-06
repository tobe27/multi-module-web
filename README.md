# **Multi-Module-Web**
基于Springboot开发的多模块JAVA WEB应用

---
### 已添加模块功能
1. spring-boot-common: 工具模块，此模块只提供工具类使用，不依赖任何模块
    1. 枚举类
    2. 加密工具类
    3. 时间转换类
    4. 参数校验类，包括空校验、长度校验、数字校验、手机号校验、邮箱校验、用户名校验、密码校验、身份证校验
    5. validation分组类，仅用于分组使用
2. spring-boot-service: service模块，包括数据底层处理、实体类
    1. dao层
    2. service层
    3. model实体
    4. mybatis-generator插件，自动生成dao、model、mapper.xml
    5. logback日志
3. spring-boot-shiro: 权限模块，此模块是基于shiro开发的用户角色权限的验证
    1. 多角色或关系配置
    2. 自定义过滤器规则
    3. 自定义认证鉴权规则
    4. 禁用Session，基于token的RESTful风格的API
4. spring-boot-web: 应用层，RESTful风格的API，统一格式返回数据
    1. controller层
    2. 全局异常处理
    3. 统一接口返回格式
    4. 基于validation的参数校验
5. spring-boot-activiti: 工作流模块，此模块是基于activiti开发的工作流模块
    1. 流程图
    2. 排他网关，通过设置condition变量来进行控制流程流转
    3. activiti工具类，完成部署，生成实例，查询任务，通过任务
6. spring-boot-mongodb: mongodb模块，基于nosql数据库mongodb对数据进行处理
    1. 配置
    2. service接口实现
    3. mongoTemplate
7. spring-boot-mq: 消息队列，基于kafka的消息队列
    1. 配置
    2. 生产消息
    3. 消费消息
8. spring-cloud-* ：微服务，基于spring cloud的微服务
    1. 服务注册中心-eureka server
    2. 服务provider - eureka client
    3. 服务consumer与负载均衡 - ribbon
    4. 断路器hystrix
    5. 网关zuul
    6. 分布式配置config
    7. 监控actuator
9. spring-boot-quartz: 定时任务,基于quartz的定时任务
    1. spring的定时任务
    2. quartz定时任务
    3. 触发器定时表达式规则
10. spring-boot-pattern: 设计模式
    1. 创建型模式
    2. 行为型模式
    3. 结构性模式
11. spring-boot-jpa: 基于JPA的ORM，不用显式写SQL语句
12. spring-boot-entity: 实体类，被依赖模块
---
### 待添加模块功能

1. spring-boot-oauth: OAuth2认证
2. spring-boot-redis: 缓存

---
