package com.example.demo.core.functional;

import java.util.function.Function;

public class SquarerTest {

    public static void main(String[] args) {
        Integer result = operate(SquarerTest::square, 2);
        Integer result2 = operate(x -> square(x), 2);
//        Integer result3 = squareOpt(x -> square(x), 2);

        System.out.println(result);
    }

    public static Integer operate(Function<Integer, Integer> function, Integer x) {
        return function.apply(x);
    }

    public static Integer square(Integer x) {
        return x*x;
    }

    // 方法重载
    public static Integer squareOpt(Squarer<Integer> squarer, Integer x) {
        return squarer.square(x);
    }
}
