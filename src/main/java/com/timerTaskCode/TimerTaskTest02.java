package com.timerTaskCode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * timerTask指定时间执行定时任务
 *
 * @author chenbin at 2017/11/8 14:40
 */
public class TimerTaskTest02 extends TimerTask{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        System.out.println(String.format("指定时间执行线程任务...%s",dateFormat.format(new Date())));
    }
}
