package com.ashim.java8.optional.immutable.stringvsbuilder;

public class TestImmutable {

	public static void main(String[] args) {
		Bar bar = new Bar(10);
		Foo foo = new Foo("test", new StringBuilder("test"), 10, bar);
		String str = "ashim";
		StringBuilder myVar = foo.getValue();
		Integer num = foo.getNum();
		Bar bar2 = foo.getBar();

		str = "ashim";
		myVar.append("ashim");
		num = 20;
		bar2.setNum(20);

		System.out.println("String");
		System.out.println("===========================");
		System.out.println(foo.getStr().hashCode());
		System.out.println(str.hashCode());

		System.out.println(foo.getStr());
		System.out.println(str);

		System.out.println();


		System.out.println("StringBuilder");
		System.out.println("===========================");
		System.out.println(foo.getValue().hashCode());
		System.out.println(myVar.hashCode());

		System.out.println(foo.getValue());
		System.out.println(myVar);

		System.out.println();

		System.out.println("Integer");
		System.out.println("===========================");
		System.out.println(foo.getNum());
		System.out.println(num.hashCode());

		System.out.println();


		System.out.println("Bar Object");
		System.out.println("===========================");
		System.out.println(foo.getBar().hashCode());
		System.out.println(bar.hashCode());
		System.out.println(bar2.hashCode());

		System.out.println(foo.getBar().getNum());
		System.out.println(bar.getNum());
		System.out.println(bar2.getNum());
	}
}
