package com.ashim.logging.ex.department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Director extends Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger("employee.director");

	public Director(final String name) {
		super(name);

		LOGGER.info("Director : {}", super.name);

		LOGGER.error("Director ERROR");
		LOGGER.warn("Director WARN");
		LOGGER.info("Director INFO");
		LOGGER.debug("Director DEBUG");
		LOGGER.trace("Director TRACE");
	}
}
