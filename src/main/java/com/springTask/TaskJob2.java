package com.springTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务2
 *
 * @author chenbin at 2017/11/7 11:45
 */
@Component("taskJob2")
public class TaskJob2 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *   字段   允许值   允许的特殊字符
         秒    0-59    , - * /
         分    0-59    , - * /
         小时    0-23    , - * /
         日期    1-31    , - * ? / L W C
         月份    1-12 或者 JAN-DEC    , - * /
         星期    1-7 或者 SUN-SAT    , - * ? / L C #
         年（可选）    留空, 1970-2099    , - * /
         - 区间
         * 通配符
         ? 你不想设置那个字段
     */
    @Scheduled(cron="0 0/1 * * * ?")
    public void job() {
        System.out.println(String.format("任务2，执行中，%s",dateFormat.format(new Date())));
    }
}
