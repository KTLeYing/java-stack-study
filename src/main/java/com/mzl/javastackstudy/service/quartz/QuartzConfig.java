package com.mzl.javastackstudy.service.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: QuartzTest
 * @Description: Quartz分布式调度任务配置
 * @Author: mzl
 * @CreateDate: 2023/10/30 1:25
 * @Version: 1.0
 */
@Configuration
public class QuartzConfig {

    /**
     * 配置任务1
     * @return 任务1配置
     */
    @Bean
    public JobDetail jobDetailOne() {
        return JobBuilder.newJob().ofType(JobOne.class)
                .storeDurably()
                .withIdentity("JobOne")
                .withDescription("JobOne")
                .build();
    }

    /**
     * 创建任务1触发器
     * @return 任务1触发器
     */
    @Bean
    public Trigger jobTriggerOne() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                // 定时间隔，单位：秒
                .withIntervalInSeconds(30)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(jobDetailOne())
                .withIdentity("JobOneTrigger")
                .withDescription("JobOneTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * 配置任务2
     * @return 任务2配置
     */
    @Bean
    public JobDetail jobDetailTwo() {
        return JobBuilder.newJob().ofType(JobTwo.class)
                .storeDurably()
                .withIdentity("JobTwo")
                .withDescription("JobTwo")
                .build();
    }

    /**
     * 创建任务2触发器
     * @return 任务2触发器
     */
    @Bean
    public Trigger jobTriggerTwo() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                // 定时间隔，单位：秒
                .withIntervalInSeconds(30)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(jobDetailTwo())
                .withIdentity("JobTwoTrigger")
                .withDescription("JobTwoTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

}