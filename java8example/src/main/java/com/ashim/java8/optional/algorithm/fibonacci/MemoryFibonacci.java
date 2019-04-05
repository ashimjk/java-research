package com.ashim.java8.optional.algorithm.fibonacci;

public class MemoryFibonacci {
	final int MAX = 100;
	final int NIL = -1;

	int lookup[] = new int[MAX];

	public static void main(String[] args) {
		MemoryFibonacci f = new MemoryFibonacci();
		int n = 40;

		long startTime = System.currentTimeMillis();
		f._initialize();
		System.out.println("Fibonacci number is" + " " + f.fib(n));
		System.out.println(System.currentTimeMillis() - startTime);
	}

	/* Function to initialize NIL values in lookup table */
	void _initialize() {
		for (int i = 0; i < MAX; i++)
			lookup[i] = NIL;
	}

	/* function for nth Fibonacci number */
	int fib(int n) {
		if (lookup[n] == NIL) {
			if (n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fib(n - 1) + fib(n - 2);
		}
		return lookup[n];
	}
}
