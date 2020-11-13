package com.example.demo.core.thirdpartapi;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface ThirdPartAPIField {
    int order() default -1;

    int length() default -1;

    String type() default "";
}
