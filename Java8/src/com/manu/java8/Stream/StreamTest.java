package com.manu.java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		String [] friends= {"Manu","Tanu","Sanu","Ramu"};
		System.out.println("Lambda Expression way");
		Arrays.stream(friends).forEach((a)->System.out.println(a));
		System.out.println("Functional programming way");
		Arrays.stream(friends).forEach(System.out::println);
		
		
		System.out.println("----------------------");
		String [] frnd= {"Manu","Tanu","Sanu","Ramu","Janu"};
		Stream<String> fStream=Stream.of(frnd);
		//fStream.forEach(b->System.out.println(b));
		//fStream.findFirst().ifPresent(System.out::print);
		fStream.findAny().ifPresent(System.out::print);
		
		System.out.println("----------------------");
		List<String> myList = Arrays.asList("a1","a2","b1","b2","b3","c4","c2","c1","c3");
		System.out.println("\n*** 1 - Print strings starting with c, sorted *** ");
		myList.stream()
		.filter(a->a.startsWith("c"))
		.map(String::toUpperCase)
		.map(s->s+" ")
		.sorted()
		.forEach(System.out::println);
		
		System.out.println("----------------------");
		myList.stream()
		.map(s->s + " ").forEach(System.out::println);
		System.out.println("----------------------");
		
		IntStream.range(1,11)
		.forEach(System.out::println);
		
		System.out.println("----------------------");
		
		
		Arrays.stream(new int[]{1,2,3})
		.map(n -> 2*n+1)
		.average()
		.ifPresent(System.out::println);
		System.out.println("----------------------");
		Stream.of("a1","a2","a3","a5")
		.map(s -> s.substring(1))
		.mapToInt(Integer::parseInt)
		.max()
		.ifPresent(System.out::println);
		
		System.out.println("----------------------");
		
		;
		Optional<Double> max = Stream.of(24.5, 23.6, 27.9, 21.1, 23.5, 25.5, 28.3).max(Double::compareTo);
		if (max.isPresent()) {
			System.out.println("Optional usage-1: " + max.get()); 		
			}
		
		max.ifPresent(System.out::println);
		System.out.println("----------------------");
		Optional<String> nonEmptyOptional = Optional.of("Hello Java 9");
		nonEmptyOptional.ifPresent(System.out::println);
		
		System.out.println("----------------------");
		Optional<String> optStr = Optional.ofNullable(null); // ok
		String result = optStr.orElse("Manu");
		System.out.println("result : " + result);
		System.out.println();
		result = optStr.orElseGet(() -> Locale.getDefault().getDisplayName());
		System.out.println("result : " + result);
		
		
		System.out.println("----------------------");
		Optional<String> string = Optional.of("     Hello World !!! ");
		string.map(String::trim).ifPresent(System.out::println);
		Optional<String> str1 = Optional.ofNullable(null);
		System.out.println(str1.map(String::length).orElse(-1));

		
		System.out.println("----------------------");
		long count1 = Stream.of(1, 2, 3, 4, 5).map(i -> i * i).count();
		System.out.printf("The stream has %d elements", count1);
		System.out.println();
		System.out.println("Square of the numbers and print with peek method >>");
		long count2 = Stream.of(1, 2, 3, 4, 5).map(i -> i * i)
				.peek(i -> System.out.printf("%d ", i)).count();
		System.out.printf("%nThe stream has %d elements", count2);
		

		System.out.println("----------------------");
		System.out.println("process pipe >>");
		Stream.of(1, 2, 3, 4, 5).peek(i -> System.out.printf("%d ", i)).map(i -> i * i)
				.peek(i -> System.out.printf("%d ", i)).count();
	}

}
