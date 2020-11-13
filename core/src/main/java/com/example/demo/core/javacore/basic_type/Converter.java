package com.example.demo.core.javacore.basic_type;

import org.junit.Test;

import java.util.Arrays;

public class Converter {

    public static byte[] longToBytes(long num) {
        byte[] buffer = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = 64 - (i + 1) * 8;
            buffer[i] = (byte)((num >> offset) & 0xff);

            System.out.println(offset);
            System.out.println(num >> offset);
            System.out.println();
        }
        return buffer;
    }

    public static long bytesToLong(byte[] b) {
        long values = 0;
        for (int i = 0; i < 8; i++) {
            values <<= 8;
            values |= b[i] & 0xff;

            System.out.println();
        }
        return values;
    }

    @Test
    public void testLongToByte() {
        System.out.println(Arrays.toString(longToBytes(1024)));
    }

    @Test
    public void testInteger() {
        System.out.println((Integer) null);
    }
}
