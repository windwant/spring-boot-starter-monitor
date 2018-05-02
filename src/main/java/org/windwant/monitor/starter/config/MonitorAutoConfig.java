package org.windwant.monitor.starter.config;

import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Configuration;
import org.windwant.monitor.starter.annotation.Monitor;
import org.windwant.monitor.starter.interceptor.MonitorInterceptor;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 18-5-2.
 */
@Configuration
public class MonitorAutoConfig extends AbstractPointcutAdvisor {

    private static final Logger logger = LoggerFactory.getLogger(MonitorAutoConfig.class);

    private Pointcut pointcut;

    private Advice advice;

    @PostConstruct
    public void init() {
        logger.info("monitor config start");
        this.pointcut = new AnnotationMatchingPointcut(null, Monitor.class);
        this.advice = new MonitorInterceptor();
        logger.info("monitor config end");
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public Advice getAdvice() {
        return this.advice;
    }
}
