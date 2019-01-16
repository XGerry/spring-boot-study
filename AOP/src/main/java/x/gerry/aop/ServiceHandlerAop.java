package x.gerry.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import x.gerry.util.DateUtil;

/**
 * @author: Gerry
 * @description: 面向切面编程 主要功能：日志记录、性能统计、安全控制、事务处理、异常处理等等
 * @date: Created in 2019/1/16
 */
@Component
@Aspect
@Order(10)
public class ServiceHandlerAop {
    private final static Logger logger = LoggerFactory.getLogger(ServiceHandlerAop.class);

    /**
     * AOP切面中的同步问题
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切入点：匹配连接点的断言
     */
    @Pointcut("execution(public * *..service..*(..))")
    public void service() {
    }

    /**
     * 前置通知：在连接点执行前的通知，但不能阻止连接点前的执行（除非它抛出一个异常）
     */
    @Before("service()")
    public void beforeAdvice() {
        logger.info("ServiceHandlerAop.beforeAdvice...time:" + DateUtil.now());
    }
}
