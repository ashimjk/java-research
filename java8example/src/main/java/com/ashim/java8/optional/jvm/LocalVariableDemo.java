package com.ashim.java8.optional.jvm;

public class LocalVariableDemo {

    public int simpleField = 10;

    public LocalVariableDemo() {
        super();
    }

    public static void main(String[] args){
        int i = 5;
        System.out.println(String.class.getClassLoader());
        System.out.println(LocalVariableDemo.class.getClassLoader());
    }

    public float test(double a) {
        return 0;
    }

}
