package com.ashim.java8.memory_leak;

public class Leak implements ILeak {
    private ILeak leak;

    public Leak(ILeak leak) {
        this.leak = leak;
    }
}