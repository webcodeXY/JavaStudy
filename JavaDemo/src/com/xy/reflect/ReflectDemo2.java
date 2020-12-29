package com.xy.reflect;

import com.xy.domain.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        User u = new User();
        Class uClass = u.getClass();
        Constructor [] declareConstructors = uClass.getDeclaredConstructors();
        for ( Constructor constructor : declareConstructors) {
            System.out.println(constructor);
        }

        Constructor constructor = uClass.getConstructor(String.class,int.class);
        Object newInstance = constructor.newInstance("zhangsan",4);
        System.out.println(newInstance);

    }
}