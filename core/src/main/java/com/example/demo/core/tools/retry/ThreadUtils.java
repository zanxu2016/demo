package com.example.demo.core.tools.retry;

import lombok.SneakyThrows;

import java.util.concurrent.ThreadFactory;

public class ThreadUtils {
    public ThreadUtils() {
    }

    @SneakyThrows
    public static void sleep(int millSeconds) {
        try {
            Thread.sleep(millSeconds);
        } catch (Throwable t) {
            throw t;
        }
    }

    public static ThreadFactory namedDaemonThreadFactory(final String name) {
        return new ThreadFactory() {
            private volatile int index = 0;

            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                t.setName(name + '-' + this.index++);
                return t;
            }
        };
    }
}
