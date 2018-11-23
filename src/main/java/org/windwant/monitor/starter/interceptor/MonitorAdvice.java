package org.windwant.monitor.starter.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * ∂®“ÂAdvice
 * Created by Administrator on 18-5-2.
 */
public class MonitorAdvice implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MonitorAdvice.class);
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        long end = System.currentTimeMillis();
        logger.info("method: {}, args: {}, execute : {} milliseconds",
                methodInvocation.getMethod().getName(), Arrays.toString(methodInvocation.getArguments()), (end - start));
        return result;
    }
}
