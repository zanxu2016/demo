package com.example.demo.core.javacore.genericity;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericityDemo {

    @Test
    public void listTest() {
        List<String> strList = Arrays.asList("aaa", "bbb");
        List<Double> doubleList = Arrays.asList(1.2, 3.4);
        List<Integer> intList = new ArrayList<>();
        intList.add(123);
        intList.add(456);

        System.out.println("strList.getClass() : \t" + strList.getClass());
        System.out.println("doubleList.getClass() : \t" + doubleList.getClass());
        System.out.println("intList.getClass() : \t" + intList.getClass());
        System.out.println("(strList.getClass() == doubleList.getClass()) : \t" + (strList.getClass() == doubleList.getClass()));
        System.out.println("(strList.getClass() == intList.getClass()) : \t" + (strList.getClass() == intList.getClass()));
        System.out.println("strList.get(0).getClass() : \t" + strList.get(0).getClass());
        System.out.println("intList.get(0).getClass() : \t" + intList.get(0).getClass());
    }

    @Test
    public void reflectInvokeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.getClass().getMethod("add", Object.class).invoke(list, "aaa");// Integer类型在编译后被擦除，只保留原始类型Object

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void initArray() {
        List<?>[] lsa = new ArrayList<?>[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<>();
        li.add(111);
        oa[0] = li;

        List<Double> li2 = new ArrayList<>();
        li2.add(222.0);
        oa[1] = li2;

        Integer i = (Integer) lsa[0].get(0);
        Double i2 = (Double) lsa[1].get(0);

        System.out.println(i);
        System.out.println(i2);



    }


}

class Pair<T extends Object> {

}
