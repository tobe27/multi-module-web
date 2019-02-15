package com.example.springbootquartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 需要执行定时任务的类
 * @author CREATED BY L.C.Y on 2019-2-15
 */
@DisallowConcurrentExecution // 多个线程执行时，不允许同步执行
public class QuartzTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务开始 ：" + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务结束 ：" + System.currentTimeMillis());
    }
}
