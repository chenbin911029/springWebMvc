package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制
 *
 * @author chenbin at 2017/11/9 10:45
 */
public class TestReflect {

    public TestReflect() {
    }

    /**
     * 反射获取类属性
     */
    public static void testGetFields() {
        Class<?> classType = ExtendType.class;

        System.out.println("--------使用 getFields--------");
        /**
         * 使用getFields获取属性
         * getFields返回的是申明为public的属性，包括父类中定义
         */

        Field[] fields = classType.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("--------使用 getDeclaredFields--------");
        /**
         * 使用getDeclaredFields获取属性
         * getDeclaredFields返回的是指定类定义的所有定义的属性，不包括父类的
         */

        fields = classType.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    /**
     * 反射获取类方法
     */
    public static void testGetMethods() {
        Class<?> classType = ExtendType.class;
        System.out.println("--------使用 getMethods 获取函数  --------");
        //返回此类中公共方法的 Method 对象的数组
        Method[] methods = classType.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("--------使用 getDeclaredMethods 获取函数 --------");
        //表示此类所有声明方法的 Method 对象的数组
        methods = classType.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    /**
     * 获取构造函数
     */
    public static void testGetConstructors(){
        Class<?> classType = ExtendType.class;
        //返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
        Constructor<?>[] constructors = classType.getConstructors();
        System.out.println("--------使用 getConstructors 这些对象反映此 Class 对象所表示的类的所有公共构造方法  --------");
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }

        /**
         * 使用getDeclaredConstructors获取构造器
         * 返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法
         */
        constructors = classType.getDeclaredConstructors();
        System.out.println("--------使用 getDeclaredConstructors " +
                "返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。  --------");
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }
    }

    /**
     * 通过反射机制创建新类的实例
     */
    public static void testCreateInstance()
            throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        Class<?> classType = ExtendType.class;
        //1.调用类的Class对象的newInstance方法，该方法会调用对象的默认构造器
        Object inst = classType.newInstance();
        System.out.println(inst);
        //2.调用默认Constructor对象的newInstance方法
        Constructor<?> constructor = classType.getConstructor();
        Object inst2 = constructor.newInstance();
        System.out.println(inst2);
        //3.调用带参数Constructor对象的newInstance方法
        Constructor<?> constructor1 = classType.getDeclaredConstructor(int.class,String.class);
        Object inst3 = constructor1.newInstance(1,"123");
        System.out.println(inst3);
    }

    //6.调用类的函数
    public static void testCallMethod()
            throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        Class<?> classType = ExtendType.class;
        Object inst = classType.newInstance();
        Method logMethod = classType.getDeclaredMethod("Log",String.class);
        logMethod.setAccessible(true);
        logMethod.invoke(inst,"test");
    }

    //7.设置/获取类的属性值
    public static void getSetField()
            throws IllegalAccessException, InstantiationException,
            NoSuchFieldException {
        Class<?> classType = ExtendType.class;
        Object inst = classType.newInstance();
        Field intField = classType.getField("pubIntExtendField");
        intField.setInt(inst,100);
        int value = intField.getInt(inst);
        System.out.println(intField);
        System.out.println(value);
    }

    /**
     * main函数
     * @param args
     */
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //testGetFields();
        //testGetMethods();
        //testGetConstructors();
        //testCreateInstance();
        //testCallMethod();
        getSetField();
    }

}
