package com.xy.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception{

        InputStream resourceAsStream = ReflectDemo4.class.getClassLoader().getResourceAsStream("prop.properties");
        Properties prop = new Properties();
        prop.load(resourceAsStream);
        System.out.println(prop);
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class uClass = Class.forName(className);
        Object o = uClass.newInstance();
        Method eat = uClass.getDeclaredMethod("eat",String.class);
        eat.invoke(o,"饭");

    }
}