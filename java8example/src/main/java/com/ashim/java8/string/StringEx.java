package com.ashim.java8.string;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringEx {

	public static void main(String[] args) {

		StringJoiner sj = new StringJoiner(", ");
		sj.add("one").add("two").add("three");

		System.out.println("sj = " + sj);

		StringJoiner sj1 = new StringJoiner(", ", "{", "}");
		System.out.println("sj1 = " + sj1);

		StringJoiner sj2 = new StringJoiner(", ", "{", "}");
		sj2.add("one");
		System.out.println("sj2 = " + sj2);

		StringJoiner sj3 = new StringJoiner(", ", "{", "}");
		sj3.add("one").add("two");
		System.out.println("sj3 = " + sj3);

		StringJoiner sj4 = new StringJoiner(", ", "{", "}");
		sj4.add("one").add("two").add("three");
		System.out.println("sj4 = " + sj4);

		String s = String.join(", ", "one", "two", "three");
		System.out.println("s = " + s);


		String s1 = String.join(", ", Arrays.asList("one", "two", "three"));
		System.out.println("s1 = " + s1);
	}
}
