package com.reflect.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象，调用目标类的方法
 *
 * @author chenbin at 2017/11/9 14:37
 */
public class TestProxy {

    public static void test(){
        //目标类
        RealSubject realSubject = new RealSubject();
        //动态代理类
        InvocationHandler handler = new DynamicSubject(realSubject);
        Class<?> classType = handler.getClass();
        //通过Proxy.newProxyInstance构建代理对象
        Subject subject = (Subject) Proxy.newProxyInstance(
                classType.getClassLoader(),//代理对象类加载器
                realSubject.getClass().getInterfaces(),//实现类的接口数组
                handler);//代理类实例
        System.out.println(subject.getClass());
        //用代理对象调用目标类的方法
        subject.Request();
    }

    public static void main(String[] args){
        test();
    }

}
