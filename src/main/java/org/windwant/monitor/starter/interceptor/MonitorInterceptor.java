package org.windwant.monitor.starter.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 18-5-2.
 */
public class MonitorInterceptor implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        long end = System.currentTimeMillis();
        logger.info("method: {} execute : {} milliseconds", methodInvocation.getMethod().getName(), (end - start));
        return result;
    }
}
