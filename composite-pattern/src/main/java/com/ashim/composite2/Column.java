package com.ashim.composite2;

public class Column {

	private String name;
	private Column parent;

	public Column(String name) {
		this.name = name;
	}

	public Column(String name, Column parent) {
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Column getParent() {
		return this.parent;
	}

	public void setParent(Column parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Column [name=" + this.name + "]";
	}

}
