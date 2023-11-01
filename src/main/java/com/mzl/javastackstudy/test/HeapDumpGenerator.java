package com.mzl.javastackstudy.test;

import com.sun.management.HotSpotDiagnosticMXBean;

import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @ClassName: HeapDumpGenerator
 * @Description: 堆内存快照文件的生成
 * @Author: mzl
 * @CreateDate: 2023/10/26 22:36
 * @Version: 1.0
 */
public class HeapDumpGenerator {

    public static void main(String[] args) throws IOException {
        // 指定Heap Dump文件名
        String dumpFileName = "heapdump.hprof";
        HotSpotDiagnosticMXBean bean = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        // 生成Heap Dump
        bean.dumpHeap(dumpFileName, true);
        System.out.println("Heap Dump generated at: " + dumpFileName);
    }

}