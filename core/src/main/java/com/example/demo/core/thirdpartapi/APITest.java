package com.example.demo.core.thirdpartapi;

import org.junit.Test;

public class APITest {

    @Test
    public void createUserTest() throws Exception {
        String name = "eric";
        int age = 20;
        String identity = "342222199510104425";
        String mobile = "15655562828";
        APICenter.createUser(name, age, identity, mobile);
    }
}
