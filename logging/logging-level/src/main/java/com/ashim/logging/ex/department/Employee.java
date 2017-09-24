package com.ashim.logging.ex.department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	protected final String name;

	public Employee(final String name) {
		this.name = name;

		LOGGER.error("Employee ERROR");
		LOGGER.warn("Employee WARN");
		LOGGER.info("Employee INFO");
		LOGGER.debug("Employee DEBUG");
		LOGGER.trace("Employee TRACE");
	}

}
