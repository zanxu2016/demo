package com.example.demo.core.tools.retry;

public final class ExceptionUtil {

    public interface RethrowConsumer<T> {
        void accept(T t) throws Throwable;
    }
}
