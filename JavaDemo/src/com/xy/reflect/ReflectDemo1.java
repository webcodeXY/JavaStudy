package com.xy.reflect;

import com.xy.domain.User;

import java.lang.reflect.Field;

public class ReflectDemo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User u = new User();
        Class uClass = u.getClass();
        Field[] declaredFields = uClass.getDeclaredFields();
        for ( Field field : declaredFields) {
            System.out.println(field);
        }
        Field nameField = uClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(u,"123");
        System.out.println(nameField.get(u));;
        System.out.println(u);
    }
}