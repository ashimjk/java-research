package com.ashim.java8.optional.immutable.stringvsbuilder;

public class Foo {

	private String str;
	private StringBuilder myVar;
	private Integer num;
	private Bar bar;

	public Foo(String str, StringBuilder initialValue, Integer num, Bar bar) {
		this.str = str;
		this.myVar = initialValue;
		this.num = num;
		this.bar = bar;
	}

	public String getStr() {
		return str;
	}

	public StringBuilder getValue() {
		return this.myVar;
	}

	public Integer getNum() {
		return this.num;
	}

	public Bar getBar() {
		return this.bar;
	}

}
