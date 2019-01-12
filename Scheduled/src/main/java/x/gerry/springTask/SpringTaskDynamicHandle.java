package x.gerry.springTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @author:Gerry
 * @description: 动态添加修改删除定时任务
 * @date: Created in 2019/1/12
 */
@RestController
public class SpringTaskDynamicHandle {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> scheduledFuture;


    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @GetMapping(value = "/start")
    public String startCron() {
        scheduledFuture = threadPoolTaskScheduler.schedule(new SpringTaskRunnable(), new CronTrigger("0/5 * * * * *"));
        return "0/5 * * * * *";
    }

    @GetMapping("/change")
    public String changeCron() {
        stopCron();
        scheduledFuture = threadPoolTaskScheduler.schedule(new SpringTaskRunnable(), new CronTrigger("0/10 * * * * *"));
        return "0/10 * * * * *";
    }

    @RequestMapping("/stop")
    public String stopCron() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        return "stop";
    }

    private class SpringTaskRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("SpringTaskDynamicHandle.SpringTaskRunnable.run()的具体业务逻辑代码：---- " + new Date());
        }
    }
}
