package com.timerTaskCode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Java timer task
 * 在实现时，Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的。
 * 当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务。 下面是代码：
 * @author chenbin at 2017/11/8 10:36
 */
public class TimerTask2 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int i=1;

    public void doJob(long delay,long intevalPeriod){
        final Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(String.format("Hello timer task.%s",dateFormat.format(new Date())));
                i++;
                if (i == 10) {
                    //取消定时任务
                    timer.cancel();
                }
            }
        };


        timer.scheduleAtFixedRate(task,delay,intevalPeriod);


    }
}
