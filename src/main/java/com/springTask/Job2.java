package com.springTask;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务类2
 *
 * @author chenbin at 2017/11/7 10:52
 */
public class Job2 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void doJob2() {
        System.out.println(String.format("不继承QuartzJobBean方式-调度进行中...%s",
                dateFormat.format(new Date())));
    }
}
