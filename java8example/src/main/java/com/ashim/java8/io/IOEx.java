package com.ashim.java8.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class IOEx {
	private static Logger ioEx = Logger.getLogger("IOEx");

	public static void main(String[] args) {
		ex1();

		ex2();

		ex3();

		ex4();

	}

	private static void ex4() {
		Path path = Paths.get("target");
//		try (Stream<Path> stream = Files.walk(path)) {
		try (Stream<Path> stream = Files.walk(path, 2)) {

			stream.filter(p -> p.toFile().isDirectory())
					.forEach(System.out::println);

		} catch (IOException ex) {
			ioEx.severe(ex.getMessage());
		}
	}

	private static void ex3() {
		Path path = Paths.get("target");
		try (Stream<Path> stream = Files.list(path)) {

			stream.filter(p -> p.toFile().isDirectory())
					.forEach(System.out::println);

		} catch (IOException ex) {
			ioEx.severe(ex.getMessage());
		}
	}

	private static void ex2() {
		Path path = Paths.get("debug.log");
		try (Stream<String> lines = Files.lines(path)) {

			lines.filter(line -> line.contains("ERROR"))
					.findFirst()
					.ifPresent(System.out::println);

		} catch (IOException ex) {
			ioEx.severe(ex.getMessage());
		}
	}

	private static void ex1() {
		try (BufferedReader reader = new BufferedReader(
				new FileReader(
						new File("debug.log")
				)
		)) {
			Stream<String> lines = reader.lines();
			lines.filter(line -> line.contains("ERROR"))
					.findFirst()
					.ifPresent(System.out::println);

		} catch (IOException ex) {
			ioEx.severe(ex.getMessage());
		}
	}
}
