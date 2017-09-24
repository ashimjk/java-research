package com.ashim.column.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Column {

	private String name;
	private Column parent;

	@JsonIgnore
	private List<Column> childs;

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

	public List<Column> getChilds() {
		if (this.childs == null) {
			this.childs = new ArrayList<>();
		}
		return this.childs;
	}

	public boolean hasParent() {
		return this.parent != null && !this.parent.getName().isEmpty();
	}

	public boolean hasChild() {
		return !this.getChilds().isEmpty();
	}

	@Override
	public String toString() {
		return "Column [name=" + this.name + "]";
	}

}
