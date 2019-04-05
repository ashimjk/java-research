package com.ashim.java8.optional.immutable;

import com.google.common.collect.ImmutableMap;

public class immutableMap {

	static final ImmutableMap<String, Test> datas =
			ImmutableMap.<String, Test>builder()
					.put("1", new Test("value"))
					.build();

	public static void main(String[] args) {

		Test t = datas.get("1");

		System.out.println(datas);
		System.out.println(t);

		t.setValue("b");

		System.out.println("---");
		System.out.println(datas);
		System.out.println(t);

		ImmutableMap<String, String> strs =
				ImmutableMap.<String, String>builder()
						.put("1", "value")
						.build();

		String s = strs.get("1");


		System.out.println("---");
		System.out.println(strs);
		System.out.println(s);

		s = "b";

		System.out.println("---");
		System.out.println(strs);
		System.out.println(s);
	}

}

class Test {

	private String value;

	Test(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Test{" +
				"value='" + value + '\'' +
				'}';
	}
}