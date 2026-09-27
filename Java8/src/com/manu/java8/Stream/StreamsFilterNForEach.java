package com.manu.java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamsFilterNForEach {

	public static void main(String[] args) {
		
		List<String> names=Arrays.asList("Manu","Tanu","Ram","Sri");
		
		System.out.println("Using for each");
		for (String name : names) {
			if(!name.equals("Manu")) {
				System.out.println(name);
			}
		}
		
		System.out.println("Using functinal programming");
		
		names.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String name) {
				return !name.equals("Manu");
			}
		}).forEach(new Consumer<String>() {
			@Override
			public void accept(String name) {
				System.out.println(name);
			}
		});
		
		System.out.println("Using lambda exp");
		
		names.stream().filter(nm-> !nm.equals("Manu"))
		.forEach(n->System.out.println(n));
		
		
		System.out.println("Using method reference(Class::Method)");
		
		names.stream().filter(StreamsFilterNForEach::isNotManu)
		.forEach(System.out::println);	
		
	}
	public static boolean isNotManu(String name) {
		return !name.equals("Manu");
	}

}
