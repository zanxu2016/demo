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
        list.getClass().getMethod("add", Object.class).invoke(list, "aaa");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}

class Pair<T extends Object> {

}
