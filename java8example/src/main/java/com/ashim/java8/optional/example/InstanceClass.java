package com.ashim.java8.optional.example;

public class InstanceClass {

    int i = 10;

    {
        m1();
        System.out.println("InstanceClass First Instance Block");
    }

    InstanceClass() {
        i = 20;
        System.out.println("InstanceClass Constructor");
    }

    public static void main(String... args) {
        InstanceClass ic = new InstanceClass();
        System.out.println("InstanceClass Main Method");
    }

    public void m1() {
        System.out.println(j);
    }

    {
        System.out.println("InstanceClass Second Instance Block");
    }

    int j= 20;

}

final class DerivedInstanceClass extends InstanceClass {

    int x = 10;

    {
        System.out.println("DerivedInstanceClass i:"+ i);
        m2();
        System.out.println("DerivedInstanceClass First Instance Block");
    }

    DerivedInstanceClass() {
        System.out.println("DerivedInstanceClass Constructor");
    }

    DerivedInstanceClass(int x) {

    }

    DerivedInstanceClass(int x, int y) {
        System.out.println(y);
    }

    public static void main(String... args) {
        System.out.println("DerivedInstanceClass Main Method");
        DerivedInstanceClass ic = new DerivedInstanceClass();
    }

    public void m2() {
        System.out.println(y);
    }

    {
        System.out.println("DerivedInstanceClass Second Instance Block");
    }

    int y= 20;

}
