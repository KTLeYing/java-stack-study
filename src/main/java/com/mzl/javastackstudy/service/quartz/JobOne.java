package com.mzl.javastackstudy.service.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JobOne
 * @Description: 任务1
 * @Author: mzl
 * @CreateDate: 2023/10/30 1:28
 * @Version: 1.0
 */
@Component
@Slf4j
public class JobOne implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        // 编写具体的业务逻辑
        log.info("任务1开始执行");
        try {
            log.info("正在执行任务1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("任务1执行异常", e);
            // 恢复中断状态
            Thread.currentThread().interrupt();
        }
        log.info("任务1执行结束");
    }

}