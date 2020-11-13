package com.example.demo.core.tools.retry;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;

public class RetryUtil {

    @SneakyThrows
    public static void retry(Action action, int retryCount, ExceptionUtil.RethrowConsumer<Throwable> errorHandler) {

        try {
            try {

            } catch (Throwable t1) {
                errorHandler.accept(t1);
            }
        } catch (Throwable t2) {
            throw t2;
        }
    }

    public static void retry(Action action, int retryCount) {
        int retry = 0;
        while (true) {
            try {
                action.apply();
                return;
            } catch (Throwable e) {
                if (++retry < retryCount) {
                    continue;
                }
                int wait = RandomUtils.nextInt(0, 1 << retry) * 100;
                ThreadUtils.sleep(wait);
                throw e;
            }
        }
    }
}
