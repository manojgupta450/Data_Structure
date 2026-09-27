package com.manu.java8.Lambda;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		String name1 = "Jack";
		String name2 = "Steve";
		Optional<String> result = changeCase(name1);
		System.out.println(result.orElse("No String present ..."));
		String s = "Hello".toUpperCase();
		result = changeCase(name2);
		result.ifPresent(System.out::println);
		System.out.println(changeCase(name2));
		// Optional.empty()
		Optional<String> emptyStr = Optional.empty();
		emptyStr.ifPresent(System.out::println);;
		System.out.println(emptyStr.orElse("Empty String .."));
	}
	private static Optional<String> changeCase(String name) {
		if (name.startsWith("S")) {
			return Optional.of(name.toUpperCase());
		}
		else return Optional.ofNullable(null);
	}
	
}
