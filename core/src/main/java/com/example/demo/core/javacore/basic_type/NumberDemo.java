package com.example.demo.core.javacore.basic_type;

import java.math.BigDecimal;

public class NumberDemo {

    public static void main(String[] args) {
        String a = "2.02106021823E11";

        BigDecimal db = new BigDecimal(a);

        System.out.println("科学计数：" + db.toString());

        System.out.println("普通计数：" + db.toPlainString());
    }
}
