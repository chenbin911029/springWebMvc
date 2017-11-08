package com.timerTaskCode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService 是从Java SE5的java.util.concurrent里，
 * 做为并发工具类被引进的，这是最理想的定时任务实现方式。
 *
 * 相比于上两个方法，它有以下好处：
 * 1>相比于Timer的单线程，它是通过线程池的方式来执行任务的
 * 2>可以很灵活的去设定第一次执行任务delay时间
 * 3>提供了良好的约定，以便设定执行的时间间隔
 *
 * 下面是实现代码，我们通过ScheduledExecutorService#scheduleAtFixedRate展示这个例子，
 * 通过代码里参数的控制，首次执行加了delay时间。
 * @author chenbin at 2017/11/8 14:11
 */
public class TimerTask3 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void doJob () {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(String.format("Hello ScheduleExcecutorService scheduleAtFixedRate.%s",
                        dateFormat.format(new Date())));
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        long initialDelay = 0L;
        long period = 1L;
        scheduledExecutorService
                .scheduleAtFixedRate(runnable,initialDelay,period, TimeUnit.MINUTES);
    }
}
