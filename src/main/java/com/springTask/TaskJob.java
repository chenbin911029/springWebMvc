package com.springTask;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务类
 *
 * @author chenbin at 2017/11/7 11:15
 */
@Component
public class TaskJob {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void job() {
        System.out.println(String.format("任务进行中...%s",dateFormat.format(new Date())));
    }
}
