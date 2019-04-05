package com.ashim.java8.memory_leak;

public class Main {
    private static ICounter counter1;
    private static ICounter counter2;

    public static void main(String[] args) throws InterruptedException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        counter1 = CounterFactory.newInstance();

        while (true) {
            counter2 = CounterFactory.newInstance();

            System.out.println("1) " +
                    counter1.message() + " = " + counter1.plusPlus());
            System.out.println("2) " +
                    counter2.message() + " = " + counter2.plusPlus());
            System.out.println();

            Thread.currentThread().sleep(3000);
        }
    }
}