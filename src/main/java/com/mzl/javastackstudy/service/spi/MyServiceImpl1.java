package com.mzl.javastackstudy.service.spi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MyServiceImpl1
 * @Description: 核心服务提供者
 * @Author: mzl
 * @CreateDate: 2023/10/28 13:05
 * @Version: 1.0
 */
@Slf4j
@Service
public class MyServiceImpl1 implements MyService{

    @Override
    public void doSomething() {
        log.info("我是核心服务提供者1");
    }

}