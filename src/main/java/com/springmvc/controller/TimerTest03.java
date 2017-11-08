package com.springmvc.controller;

import com.timerTaskCode.TimerTaskTest03;

import java.util.Timer;

/**
 * timer 指定定时任务频率
 *
 * @author chenbin at 2017/11/8 15:03
 */
public class TimerTest03 {
    Timer timer;

    public TimerTest03(){
        long delay = 1 * 1000;
        long period = 60 * 1000;
        timer = new Timer();
        timer.schedule(new TimerTaskTest03(),delay,period);
    }

    public static void main(String[] args){
        new TimerTest03();
    }
}
