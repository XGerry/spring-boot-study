package x.gerry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author: Gerry
 * @description: 操作计算 service 类：简单实现有关异步和同步两种计算方式的性能比较
 * @date: Created in 2019/1/14
 */
@Component
public class ArithmeticService {

    private final static Logger logger = LoggerFactory.getLogger(ArithmeticService.class);

    public static final int DOTIME = 5000;

    /**
     * 使用同步计算的方式--同步调用
     *
     * @return
     */
    public long subBySync() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(DOTIME);
        long end = System.currentTimeMillis();
        long sum = end - start;
        logger.info("\t 完成同步任务调用   ");
        return sum;
    }

    /**
     * 仅使用异步注解的方式实现异步方法，无返回值
     *
     * @return
     */
    @Async
    public void subByAsyncVoid() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(DOTIME);
        long end = System.currentTimeMillis();
        long sum = end - start;
        logger.info("\t 完成异步任务调用，无返回值   ");
        logger.info("注解任务执行的时间是： " + sum + "（毫秒）");
    }

    /**
     * 异步任务 只需要在所需实现异步的方法上加上@Async注解， 并通过Future<T>来接受异步方法的处理结果
     * 通过@Async注解表明该方法是个异步方法，如果注解在类级别，则表明该类所有的方法都是异步方法
     *
     * @return
     */
    @Async
    public Future<Long> subByAsync() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(DOTIME);
        long end = System.currentTimeMillis();
        long sum = end - start;
        logger.info("\t 完成异步任务调用，带返回值   ");
        return new AsyncResult<>(sum);
    }

    @Async("getMineAsync")
    public void doMineAsync(int i) throws Exception {
        System.out.println("------\t:" + i);
        Thread.sleep(10000);
    }
}
