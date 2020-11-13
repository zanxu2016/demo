package com.example.demo.core.tools.mapstruct;

public class AppleTest {

    public static void main(String[] args) {
        AppleDTO appleDTO = new AppleDTO();
        appleDTO.setAppleId(1);
        appleDTO.setKind("xxxx");
        appleDTO.setWeight(1.2345);

        Apple apple = AppleMapper.INSTANCE.toApple(appleDTO);
        System.out.println(apple);
    }
}
