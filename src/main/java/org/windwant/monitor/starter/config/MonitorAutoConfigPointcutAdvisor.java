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
 * ��֯�� ����PointCut��Advice
 * һ��̳�AbstractPointcutAdvisor�࣬��Ҫ�����ṩ Pointcut �� Advice ʵ��
 * Created by Administrator on 18-5-2.
 */
@Configuration
public class MonitorAutoConfigPointcutAdvisor extends AbstractPointcutAdvisor {

    private static final Logger logger = LoggerFactory.getLogger(MonitorAutoConfigPointcutAdvisor.class);

    private Pointcut pointcut;//��ʲô�ط�ִ��

    private Advice advice; //ִ��ʲô��BeforeAdvice��AfterAdvice��Interceptor��һ��ʵ��MethodInterceptor�ӿ�

    @PostConstruct
    public void init() {
        logger.info("monitor config start");
        this.pointcut = new AnnotationMatchingPointcut(null, Monitor.class);//����Monitor����PointCut��֯���
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
