package com.manu.java8.Stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://www.youtube.com/watch?v=bTTNVP_ORr8&index=2&list=PLTyWtrsGknYdqY_7lwcbJ1z4bvc5yEEZl
public class StreamMapperNCollect {

public static void main(String[] args) {
		
		List<String> names=Arrays.asList("Manu","Tanu","Ram","Sri");
		
		System.out.println("Using for each --------------");
		for (String name : names) {
			if(!name.equals("Manu")) {
				User user=new User(name);
				System.out.println(user);
			}
		}
		
		System.out.println("Using Stream with function -----------");
		names.stream()
		.filter(StreamsFilterNForEach::isNotManu)
		.map(new Function<String, User>() {
			@Override
			public User apply(String name) {
				return new User(name);
			}
		}).forEach(System.out::println);;	

		System.out.println("Using Stream without -----------");
		names.stream()
		.filter(StreamsFilterNForEach::isNotManu)
		.map(name->{
				return new User(name);
		}).forEach(System.out::println);;	

		
		System.out.println("Using Stream  Lambda exp-----------");
		names.stream()
		.filter(StreamsFilterNForEach::isNotManu)
		.map(name-> new User(name)).forEach(System.out::println);;	

		
		System.out.println("Using Stream method ref-----------");
		names.stream()
		.filter(StreamsFilterNForEach::isNotManu)
		.map(User::new).forEach(System.out::println);;	

		
		System.out.println("Using Stream Collect-----------");
		
		List<User> userList=names.stream()
		.filter(StreamsFilterNForEach::isNotManu)
		.map(User::new)
		.collect(Collectors.toList());;	
		
		Iterator<User> it=userList.iterator();
		while (it.hasNext()) {
			User user =it.next();
			System.out.println("Name : "+ user.getName() + ", Age : "+user.getAge());
		}
	}
	public static boolean isNotManu(String name) {
		return !name.equals("Manu");
	}


}

 class User {
	private String name;
	private int age=30;
	
	public User(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}
