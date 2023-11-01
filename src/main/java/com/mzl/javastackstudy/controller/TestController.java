package com.mzl.javastackstudy.controller;

import com.mzl.javastackstudy.service.spi.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: TestController
 * @Description: 测试
 * @Author: mzl
 * @CreateDate: 2023/10/26 23:28
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestController {

    private static final Object LOCK_A = new Object();

    private static final Object LOCK_B = new Object();

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    @PostMapping("/oomTest")
    public void oomTest(){
        List<byte[]> list = new ArrayList<>();
        try {
            while (true) {
                // 创建一个大的字节数组并添加到列表中，持续消耗堆内存(1MB)
                byte[] byteArray = new byte[1024 * 1024];
                list.add(byteArray);
            }
        } catch (OutOfMemoryError e) {
            log.error("堆内存溢出了!!！", e);
        }
    }

    @PostMapping("/deadLock")
    public void deadLock(){
        write();
        new Thread(() ->{
            synchronized (LOCK_A) {
                try {
                    log.info("线程1开始运行========");
                    Thread.sleep(2000);
                    write();
                } catch (InterruptedException e) {
                    log.error("线程异常", e);
                }
                synchronized (LOCK_B) {
                    log.info("线程1运行结束========");
                }
            }
        }).start();

        new Thread(() ->{
            synchronized (LOCK_A) {
                try {
                    log.info("线程2开始运行========");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("线程异常", e);
                }
                writeTwo();
                synchronized (LOCK_B) {
                    log.info("线程2结束运行========");
                }
            }
        }).start();

        writeTwo();

        log.info("主线程运行结束========");
    }

    private void write(){
        log.info("我的名字叫={}", "马振乐");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeTwo(){
        log.info("我的名字叫={}", "马振乐2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/cpuProblem")
    public void cpuProblem(){
        Task task1 = new Task();
        Task task2 = new Task();
        executorService.execute(task1);
        executorService.execute(task2);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            synchronized (LOCK_A) {
                long sum = 0L;
                while (true) {
                    sum += 1;
                    log.info("当前sum为{}", sum);
                }
            }
        }
    }

    @PostMapping("/spiTest")
    public void spiTest(){
        ServiceLoader<MyService> serviceLoader = ServiceLoader.load(MyService.class);
        for (MyService myService : serviceLoader){
            myService.doSomething();
        }
    }

}