package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import creational.collections.sortTest.Employee;

public class LambdaTest {

	public static void main(String[] args) {
		
		//*******************************************************************//
		/*Creating a Thread object by passing an object of anonymous Thread class 
		to the Thread constructor*/  
		Runnable r= new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread run from runnable ");
			}
		};
		Thread t =new Thread(r);
		t.start();
		
		//Creating and starting Thread using Lambda Exp 
		Runnable sr= ()->
		System.out.println("Runnable Thread run using stream");
		new Thread(sr).start();
		
		
		//Creating and staring a thread by passing an anonymous class object
		new Thread() {
			public void run() {
				System.out.println("Thread run from Thread class");
			}
		}.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println();
			}
		}).start() ;
		
		
		
		//Lambda expression can be only used with Functional interface 
		/*Thread d= () ->
		System.out.println("Thread from Thread class using stream");
		d.start();*/
		
		
		//*******************************************************************//
		
		//Sort Array of String or List using Lambda expression
		String str[] = {"Ann","do","Cn","manu","tanu","hi"};
		//Sort by length
		Arrays.sort(str, (String f1, String f2) -> Integer.compare(f1.length(), 
				f2.length()));
		System.out.println(Arrays.toString(str));

		//Reverse order sort 
		
		Arrays.sort(str, (String f1, String f2) -> {
			if(f1.length() > f2.length())
				return -1;
			else if(f1.length() < f2.length())
				return 1;
			else
				return 0;
		});
		System.out.println(Arrays.toString(str));
		
		//Sort by name
		Arrays.sort(str, (String f1, String f2) -> f1.compareTo(f2));
		System.out.println(Arrays.toString(str));
		
		
		//*******************************************************************//
		//Sorting comparator 
		
		List<Integer> l= new LinkedList<Integer>();
		l.add(10);
		l.add(20);
		l.add(5);
		
		System.out.println(l);
		Collections.sort(l, (i1,i2) -> {
			if(i1 > i2) 
				return 1;
			else if (i1 <i2)
				return -1;
			else 
				return 0;
		});
		
		System.out.println(l);
		
		List<Employee> el= new LinkedList<Employee>();
		Employee e1=new Employee(3, "Manu", 6000L); 
		Employee e2=new Employee(2, "Tanu", 7000L);
		Employee e3=new Employee(4, "Saanu", 4000L);
		el.add(e1);
		el.add(e2);
		el.add(e3);
		for(Employee e:el) {
			System.out.println(e.getEid());
		}
		
		//Sort by Employee ID 
		Collections.sort(el, (s1,s2) -> {
			if(s1.getEid() > s2.getEid()) 
				return 1;
			else if (s1.getEid() < s2.getEid())
				return -1;
			else 
				return 0;
		});
		System.out.println("Sort by employee ID");
		for(Employee e:el) {
			System.out.println(e.getEid());
		}
		
		//Sort by Employee Name 
		Collections.sort(el, (s1,s2) -> s1.getSname().compareTo(s2.getSname()));
		System.out.println("Sort by employee Name");
		for(Employee e:el) {
			System.out.println(e.getSname());
		}
		
		
		//*******************************************************************//
		System.out.println("*** User Defined Functional Interface - Adder ***");
		MathOperator mathOper = (x, y) -> x + y; // Assignment context
		System.out.println("Sum is: " + mathOper.compute(10, 15));
		MathOperator mathOper1 = (x, y) -> x * y; // Assignment context
		System.out.println("Sum is: " + mathOper1.compute(10, 15));
		
		//*******************************************************************//
		//Predefined Functional interface Consumer Supplier
		Consumer<String> c1 = s -> System.out.println("Length of String is : " + s.length());
		c1.accept("Hello");
		System.out.println();
		
		Supplier<String> s1 = () -> "Hello"; // System.out.println((() -> "HelloAgain").get()); --
		System.out.println(s1.get());
		System.out.println(); 
		
		//*******************************************************************//
		//Predefined Functional interface
		UnaryOperator<String> uOp = s -> s.toUpperCase();
		System.out.println(uOp.apply("hello"));
		
		BinaryOperator<Integer> bOp = (i, j) -> i * j;
		System.out.println(bOp.apply(3, 7));
		BinaryOperator<Double> doublebOp = (i, j) -> i + j;
		System.out.println(doublebOp.apply(3.5, 7.5));
		
		Function<Long, Double> f = x -> 1.0d / x;
		System.out.println(f.apply(5L));
		BiFunction<String, String, String> biStr = (x, y) -> x + " " + y;
		System.out.println(biStr.apply("Hello", "World"));
		
		//*******************************************************************//
		//Predicate and BiPredicate
		
		Predicate<String> p = x -> x.contains("a");
		System.out.println("Predicate - p.test(\"ha ha!!\") = " + p.test("ha ha!!"));
		BiPredicate<Integer, Integer> biP = (i, j) -> i < j;
		System.out.println("BiPredicate - biP.test(10, 4) = " + biP.test(10, 4));
		
		
		//*******************************************************************//
		System.out.println("*** User Defined Functional Interface ***");
		MyFuncInterface myFuncInterface;
		myFuncInterface = () -> 98.6;
		System.out.println("Lambda value is: " + myFuncInterface.getValue());
		System.out.println("\n");
		
		System.out.println("***  Testing ***");
		myFuncInterface=() -> {double x = 10.0;
						if (x>=100) {
							x++;
						    return x++;}
						else {x--; return x--;}
						};

		System.out.println(myFuncInterface.getValue()); 

		//*******************************************************************//
		
		
	}

	
	
	
}
