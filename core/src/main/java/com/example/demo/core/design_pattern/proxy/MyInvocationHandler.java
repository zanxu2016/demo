package com.example.demo.core.design_pattern.proxy;

import com.example.demo.core.design_pattern.proxy.advice.AfterAdvice;
import com.example.demo.core.design_pattern.proxy.advice.AfterReturningAdvice;
import com.example.demo.core.design_pattern.proxy.advice.AfterThrowingAdvice;
import com.example.demo.core.design_pattern.proxy.advice.BeforeAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        return method.invoke(this.target, args);

        Object result;
        try {
            new BeforeAdvice().before();
            result = method.invoke(this.target, args);
            new AfterAdvice().after();

            int i = 1 / 0;// 手动创建异常

        } catch (Throwable t) {
            new AfterThrowingAdvice().afterThrowing();
            throw t;
        } finally {
            new AfterReturningAdvice().afterReturning();
        }

        return result;
    }
}
