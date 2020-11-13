package com.example.demo.core.thirdpartapi;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface ThirdPartAPI {
    String desc() default "";

    String url() default "";
}