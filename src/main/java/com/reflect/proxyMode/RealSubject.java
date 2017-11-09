package com.reflect.proxyMode;

/**
 * 定义实现类
 *
 * @author chenbin at 2017/11/9 14:21
 */
public class RealSubject implements Subject{
    public void Request() {
        System.out.println("realSubject implements.");
    }
}
