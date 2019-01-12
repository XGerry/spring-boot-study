package x.gerry.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author:Gerry
 * @description:任务类
 * @date: Created in 2019/1/12
 */
public class AutoQuartz implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("AutoQuartz.execute:任务执行类 _______  ," + new Date());
    }
}
