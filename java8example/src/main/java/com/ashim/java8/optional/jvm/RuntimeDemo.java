package com.ashim.java8.optional.jvm;

import java.util.Date;

public class RuntimeDemo {

    public static void main(String[] args) {
        double mb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        System.out.println("Max Memory : " + rt.maxMemory() / mb);
        System.out.println("Total Memory : " + rt.totalMemory() / mb);
        System.out.println("Free Memory : " + rt.freeMemory() / mb);
        System.out.println("Consumed Memory : " + (rt.totalMemory() - rt.freeMemory()) / mb);

        for (int i = 1; i <= 10000; i++) {
            RuntimeDemo runtimeDemo = new RuntimeDemo();
            runtimeDemo = null;
        }

        System.out.println();
        System.out.println();

        System.out.println("Max Memory : " + rt.maxMemory() / mb);
        System.out.println("Total Memory : " + rt.totalMemory() / mb);
        System.out.println("Free Memory : " + rt.freeMemory() / mb);
        System.out.println("Consumed Memory : " + (rt.totalMemory() - rt.freeMemory()) / mb);

        rt.gc();

        System.out.println();
        System.out.println();

        System.out.println("Max Memory : " + rt.maxMemory() / mb);
        System.out.println("Total Memory : " + rt.totalMemory() / mb);
        System.out.println("Free Memory : " + rt.freeMemory() / mb);
        System.out.println("Consumed Memory : " + (rt.totalMemory() - rt.freeMemory()) / mb);

    }

}
