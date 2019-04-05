package com.ashim.java8.lambda;

import java.time.LocalDate;

public class Person {

	private String name;
	private int age;
	private LocalDate dateOfBirth;

	public Person(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	Person(int age) {
		this.age = age;
	}

	int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", dateOfBirth=" + dateOfBirth +
				'}';
	}
}
