package com.ashim.java8.optional.algorithm.fibonacci;

import java.util.Date;

public class SimpleFibonacci {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(fib(40));
		System.out.println(System.currentTimeMillis() - startTime);
	}

	static int fib(int n)
	{
		if ( n <= 1 )
			return n;
		return fib(n-1) + fib(n-2);
	}
}
