package com.ashim.java8.optional.example;

public class Base {

    static int i = 10;

    static {
        m1();
        System.out.println("Base First Static Block");
    }

    public static void main(String... args) {
        m1();
        System.out.println("Main Method");
    }

    public static void m1() {
        System.out.println(j);
    }

    static int j = 20;
}

final class Derived extends Base {

    static int x = 10;

    static {
        m1();
        System.out.println("Derived First Static Block");
    }

    public static void main(String... args) {
        m1();
        System.out.println("Main Method");
    }

    public static void m1() {
        System.out.println(y);
    }

    static {
        System.out.println("Derived Second Static Block");
    }

    static int y= 20;
}