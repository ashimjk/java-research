package com.ashim.java8.optional.enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

enum Status {
	WAITING(0),
	READY(1),
	SKIPPED(-1),
	COMPLETED(5);

	private static final Map<Integer, Status> lookup
			= new HashMap<Integer, Status>();

	static {
		for (Status s : EnumSet.allOf(Status.class))
			lookup.put(s.getCode(), s);
	}

	private int code;

	Status(int code) {
		this.code = code;
	}

	public static Status get(int code) {
		return lookup.get(code);
	}

	public int getCode() {
		return code;
	}

}

enum Status2 {
	WAITING(0),
	READY(1),
	SKIPPED(-1),
	COMPLETED(5);

	private static EnumMap<Status2, Integer> lookup = new EnumMap<Status2, Integer>(Status2.class);
	private int code;

	static {
		for (Status2 status2 : EnumSet.allOf(Status2.class)) {
			lookup.put(status2, status2.getCode());
		}
	}

	Status2(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Integer get(Status2 status2) {
		return lookup.get(status2);

	}
}

public class EnumTest {
}
