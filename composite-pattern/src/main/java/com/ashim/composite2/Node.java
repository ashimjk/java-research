package com.ashim.composite2;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int id;
	private String name;
	private int level;
	private List<Node> node;

	public Node() {
		this.node = new ArrayList<>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Node> getNode() {
		return this.node;
	}

	public void setNode(List<Node> node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "Node [id=" + this.id + ", level=" + this.level + "]";
	}

}
