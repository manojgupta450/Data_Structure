package com.manu.java8.Lambda;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Starter {

	public static void main(String[] args) {

		System.out.println("*** Lambdas - examples***");

		SimpleLambdas();
		ComparatorExample();
		ReuseMathOperation();   // User defined Functional interface
		// Built-in Functional References in Java 8
		System.out.println(" *** Predefined Functional Interfaces ***");
		System.out.println("-----------------------------------------");
		consumerExample();
		supplierExample();
		unaryOpExample();
		BinaryOpExample();
		FuncBiFuncExample();
		PredicateExample();
		UserDefinedFI();
	
		MethodRefExample();
		lambdaAsParam();
		// Threading & Closure
		lambdaRunnable();
		variableCapture();
		// Sort Persons
		sortPersonsByAge();
		FileListing();
	}

	private static void SimpleLambdas() {
		Runnable r = () -> System.out.println(
				"lambda expression implementing the run method");
				new Thread(r).start();
		
	}
	private static void ComparatorExample() {
		String[] friendList = { "Jane", "Ann", "Frank", "Al", "Robert", "Michelle" };
		System.out.println("**** Sort by Length of Names ****>>");
		Arrays.sort(friendList, (String f1, String f2) -> Integer.compare(f1.length(), 
				f2.length()));
		System.out.println(Arrays.toString(friendList));
		System.out.println("**** Reverse Sort by Length of Names - Multi-line Lambda ****>>");
		String[] friendList1 = { "Jane", "Ann", "Frank", "Al", "Robert", "Michelle" };
		Arrays.sort(friendList1, (f1, f2) -> {
			if (f1.length() > f2.length())
				return -1;
			else if (f1.length() == f2.length())
				return 0;
			else
				return 1;
		});
		System.out.println(Arrays.toString(friendList1));
		System.out.println("\n");

		System.out.println("**** Sort by Name Sequence ****>>");
		Arrays.sort(friendList1, (f1, f2) -> (f1.compareTo(f2))); // type
																	// inference
		System.out.println(Arrays.toString(friendList1));
	}

	private static void ReuseMathOperation() {
		System.out.println("*** User Defined Functional Interface - Adder ***");
		MathOperator mathOper = (x, y) -> x + y; // Assignment context
		System.out.println("Sum is: " + mathOper.compute(10, 15));
		/*mathOper = (x, y) -> x * y;
		System.out.println("Product is: " + mathOper.compute(10, 15));
		mathOper = (x, y) -> x - y;
		System.out.println("difference is: " + mathOper.compute(40, 15));*/
	}


	private static void consumerExample() {
		Consumer<String> c1 = s -> System.out.println("Length of String is : " + s.length());
		c1.accept("Hello");
		System.out.println();	}
	private static void supplierExample() {
		Supplier<String> s1 = () -> "Hello"; // System.out.println((() -> "HelloAgain").get()); --
		System.out.println(s1.get());
		System.out.println(); 	}
	private static void unaryOpExample() {
		UnaryOperator<String> uOp = s -> s.toUpperCase();
		System.out.println("Unary Operator - uOp.apply(\"hello\") = " + uOp.apply("hello"));
	}
	private static void BinaryOpExample() {
		BinaryOperator<Integer> bOp = (i, j) -> i * j;
		System.out.println("Binary Operator (Integer) - bOp.apply(3, 7) = " + bOp.apply(3, 7));
		BinaryOperator<Double> doublebOp = (i, j) -> i + j;
		System.out.println("Binary Operator (double) - dbOp.apply(3, 7) = " + 
		          doublebOp.apply(3.5, 7.5));
	}

	private static void FuncBiFuncExample() {
		Function<Long, Double> f = x -> 1.0d / x;
		System.out.println("Function - f.apply(3L) = " + f.apply(5L));
		BiFunction<String, String, String> biStr = (x, y) -> x + " " + y;
		System.out.println("BiFunction - biStr.apply(\"Hello\",\"World\") = " 
		         + biStr.apply("Hello", "World"));
	}

	private static void PredicateExample() {
		Predicate<String> p = x -> x.contains("a");
		System.out.println("Predicate - p.test(\"ha ha!!\") = " + p.test("ha ha!!"));
		BiPredicate<Integer, Integer> biP = (i, j) -> i < j;
		System.out.println("BiPredicate - biP.test(10, 4) = " + biP.test(10, 4));
	}

	private static void UserDefinedFI() {
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
	}
	
	private static void MethodRefExample() {
		System.out.println("*** Method Reference ***");
		String[] friends = { "Jane ", "Ann ", "Frank ", "Robert " };
		// Arrays.stream(friends).forEach((s) -> System.out.println(s));
		Arrays.stream(friends).forEach(Starter::highlightMe);
	}
	
	private static void highlightMe(String s) {
		System.err.println(s);
	}
	
	private static void lambdaAsParam() {
		System.out.println("\n*** Passing a Lambda to a method ***");
		// Function<String, String> func = x -> x.toLowerCase();
		changeCase("PayPal", x -> x.toUpperCase()); // PAYPAL
	}

	public static void changeCase(String name, Function<String, String> func) {
		// Typical Lambda usage scenario
		System.out.println(func.apply(name));
	}

	public static void lambdaRunnable() {

		System.out.println("*** Implementing a Runnable ***");
		// Earlier Java versions :
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread spun - pre-Java 8");
			}
		}).start();

		// Java 8 way ---->
		new Thread(() -> System.out.println("Thread spun - Lambdas way !")).start();
	}


	private static void variableCapture() {
		int k = 20;
		Consumer<Integer> con1;
		// con1 = i -> System.out.println("Incremented param is: " + k++); // no
		// mutation allowed
		con1 = i -> System.out.println("Incremented param is: " + k);
		con1.accept(k);
//		 k++; // no mutation allowed
		System.out.println("Effectively final in Java 8 Lambdas");
		// one more example >>
		// loop counter is from enclosing scope to new Threads, cannot be used
		// as it mutates
		System.out.println("Current Thread :" + Thread.currentThread().getName());
		for (int j = 0; j < 5; j++) {
			new Thread(() -> {
				// System.out.println("T - " + j + " " +
				// Thread.currentThread().getName()); // mutates
				System.out.println(Thread.currentThread().getName());
			}).start();
		}

	}

	private static void sortPersonsByAge() {
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(100, "Jane", "J", 24));
		persons.add(new Person(200, "Ann", "A", 32));
		persons.add(new Person(300, "Frank", "F", 42));
		persons.add(new Person(400, "Robert", "R", 19));

		Supplier<Person> sup = Person::new;
		Person p1 = sup.get();
		p1.setId(50); p1.setFirstName("Kate"); 	p1.setLastName("K");
		p1.setAge(24); persons.add(p1);
		persons.sort(new comparePersons());
		// persons.forEach((p) -> System.out.println(p.firstName + " - " + 		// p.age));
		System.out.println("*************************");
		persons.forEach(System.out::println);

		System.out.println("------------");
		persons.sort(Comparator.comparing(Person::getFirstName));
		persons.forEach(System.out::println);
		System.out.println("*************************");

	}
	public static void FileListing() {
		File directory = new File("./src/com/pp/");
		String[] names = directory.list(new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
		return name.endsWith(".java");
		}
		});
		System.out.println(Arrays.asList(names));
		
		// With Lambdas
		System.out.println("File list with Lambdas -->");
		String[] names1 = 
				directory.list((dir, name) -> name.endsWith(".java"));
		System.out.println(Arrays.asList(names1));
		}
	}
	
