package com.ashim.java8.optional.immutable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImmutableCollectionTest {

	@Test
	public void testList() {

		List<String> modifiableList = new ArrayList<String>();
		modifiableList.add("a");

		System.out.println("modifiableList:" + modifiableList);
		System.out.println("--");

		// unModifiableList

		assertEquals(1, modifiableList.size());

		List<String> unModifiableList = Collections.unmodifiableList(
				modifiableList);

		modifiableList.add("b");

		boolean exceptionThrown = false;
		try {
			unModifiableList.add("b");
			fail("add supported for unModifiableList!!");
		} catch (UnsupportedOperationException e) {
			exceptionThrown = true;
			System.out.println("unModifiableList.add() not supported");
		}
		assertTrue(exceptionThrown);

		System.out.println("modifiableList:" + modifiableList);
		System.out.println("unModifiableList:" + unModifiableList);

		assertEquals(2, modifiableList.size());
		assertEquals(2, unModifiableList.size());
		System.out.println("--");


		// immutableList

		List<String> immutableList = Collections.unmodifiableList(
				new ArrayList<String>(modifiableList));

		modifiableList.add("c");

		exceptionThrown = false;
		try {
			immutableList.add("c");
			fail("add supported for immutableList!!");
		} catch (UnsupportedOperationException e) {
			exceptionThrown = true;
			System.out.println("immutableList.add() not supported");
		}
		assertTrue(exceptionThrown);

		String str = immutableList.get(0);
		str = "abc";


		System.out.println("modifiableList:" + modifiableList);
		System.out.println("unModifiableList:" + unModifiableList);
		System.out.println("immutableList:" + immutableList);
		System.out.println("--");

		assertEquals(3, modifiableList.size());
		assertEquals(3, unModifiableList.size());
		assertEquals(2, immutableList.size());

		// Immutability cannot be obtain using mutable object like StringBuilder

		System.out.println("--");
		List<StringBuilder> mutableBuiler = new ArrayList<>();
		mutableBuiler.add(new StringBuilder("a"));

		List<StringBuilder> immutableBuiler = Collections.unmodifiableList(new ArrayList<>(mutableBuiler));
		mutableBuiler.add(new StringBuilder("b"));

		System.out.println(mutableBuiler);
		System.out.println(immutableBuiler);

		System.out.println("--");
		StringBuilder sb = immutableBuiler.get(0);
		sb.append("b");

		System.out.println(mutableBuiler);
		System.out.println(immutableBuiler);
	}
}
