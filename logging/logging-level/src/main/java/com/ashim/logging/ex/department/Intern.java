package com.ashim.logging.ex.department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Intern extends Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger("employee.director.manager.engineer.intern");

	public Intern(final String name) {
		super(name);

		LOGGER.info("Intern : {}", super.name);

		LOGGER.error("Intern ERROR");
		LOGGER.warn("Intern WARN");
		LOGGER.info("Intern INFO");
		LOGGER.debug("Intern DEBUG");
		LOGGER.trace("Intern TRACE");
	}

}
