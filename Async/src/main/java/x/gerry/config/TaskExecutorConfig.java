package x.gerry.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: Gerry
 * @description: 利用@EnableAsync注解开启异步任务支持
 * @date: Created in 2019/1/14
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
    /**
     * 核心线程数，核心线程会一直存活，即使没有任务需要处理。
     * 当线程数小于核心线程数时，即使现有的线程空闲，线程池也会优先创建新线程来处理任务，而不是直接交给现有的线程处理。
     * 核心线程在allowCoreThreadTimeout被设置为true时会超时退出，默认情况下不会退出。
     */
    private static final int CORE_POOL_SIZE = 5;

    /**
     * 当线程数大于或等于核心线程，且任务队列已满时，线程池会创建新的线程，直到线程数量达到maxPoolSize。
     * 如果线程数已等于maxPoolSize，且任务队列已满，则已超出线程池的处理能力，线程池会拒绝处理任务而抛出异常。
     */
    private static final int MAX_POOL_SIZE = 20;

    /**
     * 任务队列容量。从maxPoolSize的描述上可以看出，任务队列的容量会影响到线程的变化，因此任务队列的长度也需要恰当的设置。
     */
    private static final int QUEUE_CAPACITY = 10;

    /**
     * 线程池按以下行为执行任务:
     * 1.当线程数小于核心线程数时，创建线程。
     * 2.当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。
     * 3.当线程数大于等于核心线程数，且任务队列已满
     *      a.若线程数小于最大线程数，创建线程
     *      b.若线程数等于最大线程数，抛出异常，拒绝任务
     */

    /**
     * 通过重写getAsyncExecutor方法，制定默认的任务执行由该方法产生
     * <p>
     * 配置类实现AsyncConfigurer接口并重写getAsyncExcutor方法，并返回一个ThreadPoolTaskExevutor
     * 这样我们就获得了一个基于线程池的TaskExecutor
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    /**
     * 自定义任务执行器：在定义了多个任务执行器的情况下，可以使用@Async("getMineAsync")来设定
     *
     * @return
     */
    @Bean
    public Executor getMineAsync() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE - 4);
        executor.setMaxPoolSize(MAX_POOL_SIZE - 10);
        executor.setQueueCapacity(QUEUE_CAPACITY - 5);
        executor.setThreadNamePrefix("mineAsync-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
