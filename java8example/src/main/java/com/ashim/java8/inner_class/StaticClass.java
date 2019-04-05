package com.ashim.java8.inner_class;

public class StaticClass {

	int x = 10;
	static int y = 20;

	void m2() {
		System.out.println(InnerStaticClass.b);
	}

	public static void main(String[] args) {

	}

	static class InnerStaticClass {
		int a = 10;
		static int b = 20;

		void mi() {
//			System.out.println(x); cannot defined
			System.out.println(y);
		}

	}

	class InnerClass {
		int a = 10;
//		static int b = 20; cannot defined

		void mi() {
			System.out.println(x);
		}
	}
}
