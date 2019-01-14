package x.gerry.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import x.gerry.service.ArithmeticService;

import java.util.concurrent.Future;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/14
 */
@RestController
public class IndexController {
    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ArithmeticService arithmeticService;

    @SuppressWarnings("static-access")
    @GetMapping("/")
    public void index() {
        long start = System.currentTimeMillis();
        try {
            logger.info("--------------------------------------------\n");
            logger.info("每个任务执行的时间是：" + arithmeticService.DOTIME + "（毫秒）");
            Future<Long> task = arithmeticService.subByAsync();
            arithmeticService.subByAsyncVoid();
            long sync = arithmeticService.subBySync();
            while (true) { //这里使用了循环判断，等待获取结果信息
                if (task.isDone()) { //判断是否执行完毕
                    long async = task.get();
                    logger.info("异步任务执行的时间是：" + async + "（毫秒）");
                    logger.info("同步任务执行的时间是：" + sync + "（毫秒）");
                    break;
                }
            }
            logger.info("--------------------------------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("\t........请求响应时间为：" + (end - start) + "（毫秒）");
    }

    /**
     * 自定义实现线程异步
     */
    @GetMapping("/mine")
    public void mineAsync() {
        for (int i = 0; i < 100; i++) {
            try {
                arithmeticService.doMineAsync(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
