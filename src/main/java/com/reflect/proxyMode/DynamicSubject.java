package com.reflect.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义代理类
 *
 * @author chenbin at 2017/11/9 14:25
 */
public class DynamicSubject implements InvocationHandler {
    private Object sub;

    public DynamicSubject(Object obj){
        this.sub = obj;
    }
    //将目标类实例对象传入代理类,代理类实现InvocationHandler,的invoke()方法
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Method:"+method+",Args:"+args);
        method.invoke(sub,args);
        return null;
    }
}
