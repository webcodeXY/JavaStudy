package com.xy.reflect;

import com.xy.domain.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception{
        User u = new User();
        Class uClass = u.getClass();

        Method[] declaredMethods = uClass.getDeclaredMethods();

        for (Method method:declaredMethods) {
            System.out.println(method);
        }

        Method eat = uClass.getDeclaredMethod("eat", String.class);
        eat.invoke(u,"fan");

    }
}