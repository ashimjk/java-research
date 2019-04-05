package com.ashim.java8.optional.jvm;

public class HeapDemo {

    public static void main(String[] args) {
        double mb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        System.out.println("Max Memory : " + rt.maxMemory() / mb);
        System.out.println("Total Memory : " + rt.totalMemory() / mb);
        System.out.println("Free Memory : " + rt.freeMemory() / mb);
        System.out.println("Consumed Memory : " + (rt.totalMemory() - rt.freeMemory()) / mb);
    }

}
