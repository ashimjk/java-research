package com.ashim.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(2, 4, 6, 7);
		List<Integer> list3 = Arrays.asList(1, 3, 4);

		List<List<Integer>> list = Arrays.asList(list1, list2, list3);

		Function<List<?>, ?> size = List::size;
		Function<List<?>, Stream<?>> stream = List::stream;
		BinaryOperator<Integer> bo = (a, b) -> a + b;

		BiConsumer<List<Integer>, Integer> bc = List::add;

		Integer integer = list.stream()
				.flatMap(stream)
				.map(String::valueOf)
				.map(Integer::parseInt)
				.reduce(50, bo);

		System.out.println(integer);

		List<Person> persons = Arrays.asList(
				new Person(20),
				new Person(30),
				new Person(20),
				new Person(31)
		);
		Map<Integer, Long> result = persons.stream()
				.collect(
						Collectors.groupingBy(
								Person::getAge,
								Collectors.counting()
						)
				);

		result.keySet().forEach(s -> System.out.println(s + " : " + result.get(s)));

	}

}
