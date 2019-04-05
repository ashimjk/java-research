package com.ashim.java8.date;

import com.ashim.java8.lambda.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateAndTime {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		InputStream peopleStream = DateAndTime.class.getClassLoader().getResourceAsStream("people.txt");
		InputStreamReader in = new InputStreamReader(peopleStream);
		try (
				BufferedReader reader = new BufferedReader(in);
				Stream<String> stream = reader.lines()
		) {

			stream.map(line -> {
				String[] s = line.split(" ");
				String name = s[0].trim();
				int year = Integer.parseInt(s[1]);
				Month month = Month.of(Integer.parseInt(s[2]));
				int day = Integer.parseInt(s[3]);

				Person p = new Person(name, LocalDate.of(year, month, day));
				persons.add(p);
				return p;
			})
					.forEach(System.out::println);

			LocalDate now = LocalDate.now();

			persons.forEach(p -> {
				Period period = Period.between(p.getDateOfBirth(), now);

				System.out.println(p.getName() + " was born "
						+ period.get(ChronoUnit.YEARS) + " years and "
						+ period.get(ChronoUnit.MONTHS) + " months and "
						+ "[" + p.getDateOfBirth().until(now, ChronoUnit.MONTHS)
						+ " months]");
			});

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
