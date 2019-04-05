package com.ashim.java8.map;

import com.ashim.java8.date.DateAndTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiMapEx {

	public static void main(String[] args) {

		List<People> peoples = new ArrayList<>();

		InputStream peopleStream = DateAndTime.class.getClassLoader().getResourceAsStream("people2.txt");
		InputStreamReader in = new InputStreamReader(peopleStream);
		try (
				BufferedReader reader = new BufferedReader(in);
				Stream<String> stream = reader.lines()
		) {

			stream.map(line -> {
				String[] s = line.split(" ");
				String name = s[0].trim();
				int age = Integer.parseInt(s[1]);
				String gender = s[2].trim();

				People p = new People(name, age, gender);
				peoples.add(p);
				return p;
			})
					.forEach(System.out::println);

			Map<Integer, List<People>> map = mapByAge(peoples);
			System.out.println("Map");
			map.forEach((age, list) -> System.out.println(age + " -> " + list));

			Map<Integer, Map<String, List<People>>> bimap = new HashMap<>();

			peoples.forEach(
					people ->
							bimap.computeIfAbsent(
									people.getAge(),
									HashMap::new
							)
					.merge(people.getGender(),
							new ArrayList<>(Collections.singletonList(people)),
							(l1, l2) -> {
								l1.addAll(l2);
								return l1;
							})

			);

			System.out.println("BiMap");
			bimap.forEach((age, list) -> System.out.println(age + " -> " + list));


		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static Map<Integer, List<People>> mapByAge(List<People> list) {
		return list.stream()
				.collect(
						Collectors.groupingBy(
								People::getAge
						)
				);

	}
}
