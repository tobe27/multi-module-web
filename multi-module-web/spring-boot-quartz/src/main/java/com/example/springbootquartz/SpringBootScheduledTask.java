package com.example.springbootquartz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

/**
 * Spring定时任务，直接运行即可，不需要调用
 * @author CREATED BY L.C.Y on 2019-2-15
 */
@Component
@Configurable
@EnableScheduling
public class SpringBootScheduledTask {

    // 30秒执行一次
    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime() {
        System.out.println("Scheduling Task : The time is now " + System.currentTimeMillis());
    }

    // 每1分钟执行一次
    @Scheduled(cron = "0 */1 * * * *")
    public void reportCurrentByCron() {
        System.out.println("Scheduling Task By Cron : The time is now " + System.currentTimeMillis());
    }
}
