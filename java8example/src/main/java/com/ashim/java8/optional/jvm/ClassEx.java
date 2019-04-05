package com.ashim.java8.optional.jvm;

public class ClassEx {

    public static void main(String... args) {
        Student s1 = new Student();
        Class c1 = s1.getClass();
        Student s2 = new Student();
        Class c2 = s2.getClass();

        System.out.println("Class1 : " + c1.hashCode());
        System.out.println("Class2 : " + c2.hashCode());

        System.out.println("Student1 : " + s1.hashCode());
        System.out.println("Student2 : " + s2.hashCode());

        System.out.println(c1 == c2);
        System.out.println(s1 == s2);
    }
}

class Student {
    int rollNo;
}
