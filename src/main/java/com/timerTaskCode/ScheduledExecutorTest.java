package com.timerTaskCode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 用ScheduledExecutorService替代Timer
 * 可并发执行多个任务
 * 用相对时间管理任务的间隔
 * @author chenbin at 2017/11/8 15:54
 */
public class ScheduledExecutorTest {
    private ScheduledExecutorService scheduExec;
    public long start;

    ScheduledExecutorTest(){
        this.scheduExec = Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void timerOne(){
        scheduExec.schedule(new Runnable(){
            public void run() {
                System.out.println("timerOne,the time:" + (System.currentTimeMillis() - start));
                //throw new RuntimeException();
            }
        },1, TimeUnit.SECONDS);
    }

    public void timerTwo(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                //System.out.println("我会不会执行呢？？");
                System.out.println("timerTwo,the time:" + (System.currentTimeMillis() - start));
            }
        },2,TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorTest test = new ScheduledExecutorTest();
        test.timerOne();
        test.timerTwo();
    }
}
