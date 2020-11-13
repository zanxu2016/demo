package com.example.demo.core.tools.operator;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Operator {
    private int sort;

    @Test
    public void test() {
        int a = 0b111;
        int b = 0b100;
        System.out.println(Integer.toBinaryString(a ^ b));
        System.out.println(Integer.toBinaryString(1 << 3));
    }

    @Test
    public void sortTest() {
        System.out.println(setSort(initCompanyLabels()));
    }

    public int setSort(List<String> companyLabels) {
        if (CollectionUtils.isEmpty(companyLabels)) {
            return 0b000;
        }
        int sort = 0b100;
        for (String companyLabel : companyLabels) {
            sort = cal(companyLabel, sort);
        }

        return sort;
    }

    private int cal(String companyLabel, int sort) {

        System.out.println("in----- companyLabel=" + companyLabel + ", sort=" + sort);

        if (StringUtils.equals(companyLabel, "2")) {
            sort = sort & 0b011;
        }

        if (StringUtils.equalsAny(companyLabel, "3", "4")) {
            sort = sort | 0b010;
        }

        if (StringUtils.equalsAny(companyLabel, "6", "7")) {
            sort = sort | 0b001;
        }
        System.out.println("out----- companyLabel=" + companyLabel + ", sort=" + sort);
        System.out.println();

        return sort;
    }

    public List<String> initCompanyLabels() {
        return Arrays.asList("1", "3", "6");
    }

    @Test
    public void testDivide() {
        System.out.println(10 * 100 / 100);
    }

    @Test
    public void testStream() {
        Integer integer = Stream.of(2,2).min(Integer::compareTo).get();
        System.out.println(integer);
    }
}
