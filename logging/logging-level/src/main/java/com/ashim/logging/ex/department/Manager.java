package com.ashim.logging.ex.department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Manager extends Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger("employee.director.manager");

	public Manager(final String name) {
		super(name);

		LOGGER.info("Manager : {}", super.name);

		LOGGER.error("Manager ERROR");
		LOGGER.warn("Manager WARN");
		LOGGER.info("Manager INFO");
		LOGGER.debug("Manager DEBUG");
		LOGGER.trace("Manager TRACE");
	}
}
