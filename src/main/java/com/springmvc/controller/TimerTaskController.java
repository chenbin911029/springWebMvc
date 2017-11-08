package com.springmvc.controller;

import com.timerTaskCode.TimerTask2;
import com.timerTaskCode.TimerTask3;

/**
 * 定时任务调用controller
 *
 * @author chenbin at 2017/11/8 11:32
 */
public class TimerTaskController {
    public static void main(String[] args) {
        TimerTask2 timerTask2 = new TimerTask2();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        // schedules the task to be run in an interval
        timerTask2.doJob(delay,intevalPeriod);

        TimerTask3 timerTask3 = new TimerTask3();
        timerTask3.doJob();
    }
}
