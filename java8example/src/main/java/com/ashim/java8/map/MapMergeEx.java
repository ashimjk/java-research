package com.ashim.java8.map;

import com.ashim.java8.date.DateAndTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMergeEx {

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

			List<People> list1 = peoples.subList(0, 10);
			List<People> list2 = peoples.subList(10, peoples.size());

			Map<Integer, List<People>> map1 = mapByAge(list1);
			System.out.println("Map 1");
			map1.forEach((age, list) -> System.out.println(age + " -> " + list));

			Map<Integer, List<People>> map2 = mapByAge(list2);
			System.out.println("Map 2");
			map2.forEach((age, list) -> System.out.println(age + " -> " + list));

			map2.forEach((key, value) ->
					map1.merge(
							key,
							value,
							(l1, l2) -> {
								l1.addAll(l2);
								return l1;
							}
					)
			);

			System.out.println("Map 1");
			map1.forEach((age, list) -> System.out.println(age + " -> " + list));

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
