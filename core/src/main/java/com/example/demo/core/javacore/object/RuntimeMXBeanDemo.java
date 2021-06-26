package com.example.demo.core.javacore.object;

import java.lang.management.ManagementFactory;

public class RuntimeMXBeanDemo {
    public static void main(String[] args) {
        // 获取进程ID-processId
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name.split("@")[0]);
    }
}
