package com.xy.annotation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class AnnotionDemo {
    public static void main(String[] args) throws Exception {

        Class<Calculator> calculatorClass = Calculator.class;
        Method[] declaredMethods = calculatorClass.getDeclaredMethods();
        Calculator c = calculatorClass.newInstance();


        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        int errorNum = 0;
        for (Method m:declaredMethods) {
            if(m.isAnnotationPresent(Check.class)){
                try {
                    m.invoke(c);
                } catch (Exception e){
                    errorNum++;
                    bw.write("报错啦，错误位置AnnotationDemo 22 行");
                    bw.newLine();
                    bw.write("错误的方法名称为" + m.getName());
                    bw.newLine();
                    bw.write("错误的类名为" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("错误的原因为" + e.getCause().getMessage());
                    bw.newLine();
                }
            }
        }

        bw.write("错误的次数为" + errorNum);
        bw.flush();
        bw.close();
    }
}
