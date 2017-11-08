package com.springTask;

import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务，作业类
 *
 * @author chenbin at 2017/11/7 9:30
 */
public class HelloJob extends QuartzJobBean {

    private int timeout;
    private static int i = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //调度工厂实例化后，经过timeout时间开始执行调度
    public void setTimeout(int timeout){
        this.timeout = timeout;
    }

    /**
     * 需要调度的具体任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        System.out.println(String.format("定时任务执行中...%s",dateFormat.format(new Date())));
    }
}
