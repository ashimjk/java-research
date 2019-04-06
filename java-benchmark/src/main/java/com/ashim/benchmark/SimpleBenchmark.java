package com.ashim.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Warmup;

public class SimpleBenchmark {

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 5)
    public void init() {

    }
}
