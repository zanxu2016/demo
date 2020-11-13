package com.example.demo.core.javacore.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * 各数据类型在堆内存中所占空间
 * JVM默认开启压缩指针
 * 开启   -XX:+UseCompressedOops
 * 关闭   -XX:-UseCompressedOops
 *
 * pom.xml添加依赖，打印出对象内部属性占用空间情况
 * <dependency>
 *     <groupId>org.openjdk.jol</groupId>
 *     <artifactId>jol-core</artifactId>
 *     <version>0.10</version>
 * </dependency>
 *
 */
public class HeapMemory {

    Object obj1 = new Object();

    byte b = 0xf;
    boolean isOk = true;
    char gender = '1';
    short age = 28;
    int workYear = 10;
    long tm = 1234567890123456789L;
    float score = 89.5F;
    double salary = 10000.0;

    public static void main(String[] args) {
//        Object obj2 = new Object();
//        System.out.println(ClassLayout.parseInstance(obj2).toPrintable());
//        System.out.println();
        HeapMemory heapMemory = new HeapMemory();
        System.out.println(ClassLayout.parseInstance(heapMemory).toPrintable());
        System.out.println(heapMemory.hashCode());
//        System.out.println();
//        System.out.println(ClassLayout.parseInstance(heapMemory.obj1).toPrintable());
    }
}
