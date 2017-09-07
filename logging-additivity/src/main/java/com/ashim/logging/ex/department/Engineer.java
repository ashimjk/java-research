package com.ashim.logging.ex.department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Engineer extends Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger("employee.director.manager.engineer");

	public Engineer(final String name) {
		super(name);

		LOGGER.info("Engineer : {}", super.name);

		LOGGER.error("Engineer ERROR");
		LOGGER.warn("Engineer WARN");
		LOGGER.info("Engineer INFO");
		LOGGER.debug("Engineer DEBUG");
		LOGGER.trace("Engineer TRACE");
	}

}
