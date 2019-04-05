package com.ashim.java8.optional.jvm;

public class StringPool {

    public static void main(String... args) {

        String s1 = "cat";
        String s2 = "cat";
        String s3 = "dog";
        String s4 = new String("cat");
        String s5 = s4.intern();

        System.out.println("s1 == s2 : " + (s1 == s2));
        System.out.println("s1 == s3 : " + (s1 == s3));
        System.out.println("s1 == s2 : " + (s1 == s4));
        System.out.println("s1 == s2 : " + (s1 == s5));
    }

}
