package com.ashim.column.constant;

import java.util.HashMap;
import java.util.Map;

public enum ColumnLvlEnum {

	A(1, "A"), B(2, "B"), C(3, "C"), D(4, "D"), E(5, "E"), F(6, "F"), G(7, "G");

	private final Integer id;
	private final String desc;

	// Reserve-lookup map for getting column level
	static Map<Integer, String> lookup = new HashMap<>();

	static {
		for (ColumnLvlEnum c : ColumnLvlEnum.values()) {
			lookup.put(c.id, c.desc);
		}
	}

	private ColumnLvlEnum(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return this.id;
	}

	public String getDesc() {
		return this.desc;
	}

	public static String getDesc(int id) {
		return lookup.get(id);
	}

}
