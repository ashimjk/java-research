package com.ashim.logging.ex;

import com.ashim.logging.ex.department.Director;
import com.ashim.logging.ex.department.Employee;
import com.ashim.logging.ex.department.Engineer;
import com.ashim.logging.ex.department.Intern;
import com.ashim.logging.ex.department.Manager;

public class App {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Employee director = new Director("Pabitra");

		Employee manager = new Manager("Aashish");

		Employee engineer = new Engineer("Ashim");

		Employee intern = new Intern("Aadarsha");
	}
}
