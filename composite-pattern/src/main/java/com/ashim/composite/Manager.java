package com.ashim.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager implements Employee {

	private String name;
	private double salary;
	private List<Employee> employees = new ArrayList<>();

	public Manager(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public void add(Employee employee) {
		this.employees.add(employee);
	}

	@Override
	public Employee getChild(int i) {
		return this.employees.get(i);
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

		Iterator<Employee> employeeIterator = this.employees.iterator();
		while (employeeIterator.hasNext()) {
			Employee employee = employeeIterator.next();
			employee.print();
		}
	}

	@Override
	public void remove(Employee employee) {
		this.employees.remove(employee);
	}

}