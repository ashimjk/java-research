package com.ashim.java8.memory_leak;

public class Counter implements ICounter {
    private int counter;

    public ICounter copy(ICounter other) {
        if (other != null)
            counter = other.counter();
        return this;
    }

    public String message() {
        return "Version 1";
    }

    public int plusPlus() {
        return counter++;
    }

    public int counter() {
        return counter;
    }
}