package org.windwant.monitor.starter.config;

import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Configuration;
import org.windwant.monitor.starter.annotation.Monitor;
import org.windwant.monitor.starter.interceptor.MonitorAdvice;

import javax.annotation.PostConstruct;

/**
 * 编织器 关联PointCut和Advice
 * 一般继承AbstractPointcutAdvisor类，需要子类提供 Pointcut 和 Advice 实例
 * Created by Administrator on 18-5-2.
 */
@Configuration
public class MonitorAutoConfigPointcutAdvisor extends AbstractPointcutAdvisor {

    private static final Logger logger = LoggerFactory.getLogger(MonitorAutoConfigPointcutAdvisor.class);

    private Pointcut pointcut;//在什么地方执行

    private Advice advice; //执行什么；BeforeAdvice，AfterAdvice，Interceptor，一般实现MethodInterceptor接口

    @PostConstruct
    public void init() {
        logger.info("monitor config start");
        this.pointcut = new AnnotationMatchingPointcut(null, Monitor.class);//创建Monitor声明PointCut；织入点
        this.advice = new MonitorAdvice();
        logger.info("monitor config end");
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public Advice getAdvice() {
        return this.advice;
    }
}
