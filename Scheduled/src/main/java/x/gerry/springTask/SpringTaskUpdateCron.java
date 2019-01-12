package x.gerry.springTask;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author:Gerry
 * @description:动态修改定时任务的执行周期
 * @date: Created in 2019/1/12
 */

@Component
@EnableScheduling
public class SpringTaskUpdateCron implements SchedulingConfigurer {

    public static String cron;

    public SpringTaskUpdateCron() {
        cron = "0/5 * * * * *";
        new Thread(() -> {
            try {
                Thread.sleep(20000);
                cron = "0/10 * * * * *";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Runnable task = () -> {
            /**
             * 任务逻辑代码部分
             */
            System.out.println("SpringTaskUpdateCron task is running ...... " + new Date());
        };

        Trigger trigger = triggerContext -> {
            //任务触发，可修改任务的执行周期
            CronTrigger trigger1 = new CronTrigger(cron);
            Date nextExec = trigger1.nextExecutionTime(triggerContext);
            return nextExec;
        };

        scheduledTaskRegistrar.addTriggerTask(task, trigger);

    }
}
