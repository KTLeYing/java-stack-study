package com.mzl.javastackstudy.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OOMTest
 * @Description: OOM测试
 * @Author: mzl
 * @CreateDate: 2023/10/26 22:33
 * @Version: 1.0
 */
public class OOMTest {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        try {
            while (true) {
                // 创建一个大的字节数组并添加到列表中，持续消耗堆内存(1MB)
                byte[] byteArray = new byte[1024 * 1024];
                list.add(byteArray);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError caught!");
        }
    }

}