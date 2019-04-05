package com.ashim.java8.optional.algorithm.fibonacci;

public class TabularFibonacci {

	public static void main(String[] args) {
		TabularFibonacci f = new TabularFibonacci();
		int n = 40;

		long startTime = System.currentTimeMillis();
		System.out.println("Fibonacci number is" + " " + f.fib(n));
		System.out.println(System.currentTimeMillis() - startTime);
	}

	int fib(int n) {
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++)
			f[i] = f[i - 1] + f[i - 2];
		return f[n];
	}
}
