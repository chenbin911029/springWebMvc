package com.timerTaskCode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * 在延迟指定时间后以指定的间隔时间循环执行定时任务
 *
 * @author chenbin at 2017/11/8 14:53
 */
public class TimerTaskTest03 extends TimerTask{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println(String.format("执行该线程的时间为：%s",dateFormat.format(date)));
    }
}
