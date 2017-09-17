package com.ashim.composite;

/**
 * In this class,there are many methods which are not applicable to developer
 * because it is a leaf node.
 */
public class Developer implements Employee {

	private String name;
	private double salary;

	public Developer(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getSalary() {
		return this.salary;
	}

	@Override
	public void print() {
		System.out.println("-------------");
		System.out.println("Name =" + this.getName());
		System.out.println("Salary =" + this.getSalary());
		System.out.println("-------------");
	}

	@Override
	public void add(Employee employee) {
		// this is leaf node so this method is not applicable to this class.
	}

	@Override
	public Employee getChild(int i) {
		// this is leaf node so this method is not applicable to this class.
		return null;
	}

	@Override
	public void remove(Employee employee) {
		// this is leaf node so this method is not applicable to this class.
	}

}