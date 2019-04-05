package com.ashim.java8.inner_class;

import java.util.HashMap;
import java.util.Map;

public class AnonymousImpl {
	public static void main(String[] args) {

		Popcorn popcorn = new Popcorn();
		popcorn.taste();
		popcorn.item();

		Popcorn popcorn1 = new Popcorn() {
			void taste() {
				System.out.println("Spicy");
			}
		};

		popcorn1.taste();
		popcorn1.item();

		Popcorn popcorn2 = new Popcorn() {{
			taste();
			item();
		}};

		Map<String, String> fruits = new HashMap<String, String>() {{
			put("1", "apple");
			put("2", "orance");
			put("3", "grapes");
		}};

		System.out.println(fruits);
	}
}

class Popcorn {
	void taste() {
		System.out.println("Salty");
	}

	void item() {
		System.out.println("Item");
	}
}
