package com.manu.java8.Stream;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		 CreateStreams();
		 BasicStream();
		 PrimitiveStreams();
		 optionalDemo();
		 count();
		 processPipe();
		 doubleStream();
		// Search & process flow operations
		 searchOps();
		 searchClassMethodNames();
		 lazyProcess();
		 cannotReuseStream();
		 ProcFlowAndSortExecution();
		 supplierGet();
		 infiniteStream();
		 bigIntIterate();
		 mathOps();
		
		 sortedWordList();
		 flatMapExample();
		 reduceExample();
		 collectExamples();
		 partitionBy();
		parallelExample();
		fileIO();
		parallelReduce();
		parallelStreamWithCombiner();
		forEachOrdered();
	}
	private static void CreateStreams() {
		String[] friends = { "Jane ", "Ann ", "Frank ", "Robert " };
		Arrays.stream(friends).forEach((s) -> System.out.println(s));
		System.out.println();
		System.out.println("*** Creating stream from Array ***");
		String[] friendList = { "Jane", "Ann", "Frank", "Al", "Robert", "Michelle" };
		Stream<String> friendStream = Stream.of(friendList);

				friendStream.forEach(friend -> System.out.println(friend));
/*Method ref */ friendStream.findFirst().ifPresent(System.out::println);

		System.out.println("*** Random Scores ***");
		friendStream.forEach(friend -> System.out.println(friend + " - Score : " + Math.floor(Math.random() * 100)));
		System.out.println("\n");
	}
	
	private static void BasicStream() {
		List<String> myList = Arrays.asList("a1","a2","b1","b2","b3","c4","c2","c1","c3");
		System.out.println("\n*** 1 - Print strings starting with c, sorted *** ");
		myList
		.stream()
		.filter(s->s.startsWith("c"))
		.map(String::toUpperCase)
		.map(s->s+" ")
		.sorted()
		.forEach(System.out::print);
		
		System.out.print("\t (Streams are non-interfering, i.e, Original Array is intact) >>");
		myList
		.stream().map(s->s+" ")
		.forEach(System.out::print);
		
	}
	
	private static void PrimitiveStreams() {
		System.out.println("\n ** 3 - Usage of IntStream**");
		IntStream.range(1,11)
			.forEach(System.out::print);
		System.out.println("\n ** 4 - IntStream - Average & Sum functions**");
		Arrays.stream(new int[]{1,2,3})
			.map(n -> 2*n+1)
			.average()
			.ifPresent(System.out::println);
		System.out.println("\n ** 5 - Transform Regular Stream to a Primitive Stream (in this case, an IntStream) **");
		Stream.of("a1","a2","a3","a5")
			.map(s -> s.substring(1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(System.out::println);
		
		System.out.println("\n ** 6 - DoubleStream to IntStream to Object Stream transform **");
		Stream.of(10.0,20.0,30.0,40.0).mapToInt(Double::intValue).mapToObj(i->"a"+i).forEach(System.out::println);

	}
	
	private static void optionalDemo() {
		System.out.println("Optional Demo");
		// Optional usage
		Stream<Double> priceStream = Stream.of(24.5, 23.6, 27.9, 21.1, 23.5, 25.5, 28.3);
		Optional<Double> max = priceStream.max(Double::compareTo);
		if (max.isPresent()) {
			System.out.println("Optional usage-1: " + max.get()); 		}
		System.out.print("Optional usage-2: ");
		max.ifPresent(System.out::println);  //pass the value to a consumer
		// Create optional obj
		Optional<String> empty = Optional.empty();
		Optional<String> nonEmptyOptional = Optional.of("Hello Java 9");
		nonEmptyOptional.ifPresent(System.out::println);

		// Optional<String> nullStr = Optional.of(null); // throws error
		Optional<String> optStr = Optional.ofNullable(null); // ok
		String result = optStr.orElse("");
		System.out.println("result : " + result);
		System.out.println();
		result = optStr.orElseGet(() -> Locale.getDefault().getDisplayName());
		System.out.println("result : " + result);
		System.out.println();
		Optional<String> string = Optional.of("     Hello World !!! ");
		string.map(String::trim).ifPresent(System.out::println);
		Optional<String> str1 = Optional.ofNullable(null);
		System.out.println(str1.map(String::length).orElse(-1));
    	Optional<String> str2 = Optional.ofNullable(null);
		// System.out.println(str2.map(String::length).orElseThrow(IllegalArgumentException::new));
		// // throws error
		getHighestPrice(Stream.of(24.5, 23.6, 27.9, 21.1, 23.5, 25.5, 28.3));
		getHighestPrice(Stream.of()); // Prints Optional.empty
		
		// Optional Int
		OptionalInt numb = OptionalInt.of(Integer.parseInt("250",10));
		System.out.println("Number is: " + numb.orElse(1000)); 	}

	public static void getHighestPrice(Stream<Double> prices) {
		System.out.println(prices.max(Double::compareTo));
	}

	public static void count() { // Get the count of number of elements in a Stream
		// 2 versions
		long count1 = Stream.of(1, 2, 3, 4, 5).map(i -> i * i).count();
		System.out.printf("The stream has %d elements", count1);
		System.out.println();
		System.out.println("Square of the numbers and print with peek method >>");
		long count2 = Stream.of(1, 2, 3, 4, 5).map(i -> i * i)
				.peek(i -> System.out.printf("%d ", i)).count();
		System.out.printf("%nThe stream has %d elements", count2);
	}

	public static void processPipe() {  // This demonstrates the order of evaluation
		System.out.println("process pipe >>");
		Stream.of(1, 2, 3, 4, 5).peek(i -> System.out.printf("%d ", i)).map(i -> i * i)
				.peek(i -> System.out.printf("%d ", i)).count();
	}
	private static void doubleStream() { // Apply Square root and Sum a list of doubles 
		System.out.println();
		double d = DoubleStream.of(1.0, 4.0, 9.0).map(Math::sqrt)
				.peek(System.out::println).sum();

		System.out.println("Sum of Square Roots of List items: " + d);
		System.out.println();
	}
	private static void searchOps() {
		// Temperature recorded in a week
		boolean anyMatch = IntStream.of(56, 57, 55, 52, 48, 51, 49)
				.anyMatch(temp -> temp < 60);
		System.out.println("anyMatch(temp -> temp < 60): " + anyMatch);
		boolean allMatch = IntStream.of(56, 57, 55, 52, 48, 51, 49)
				.allMatch(temp -> temp > 60);
		System.out.println("allMatch(temp -> temp > 60): " + allMatch);
		boolean noneMatch = IntStream.of(56, 57, 55, 52, 48, 51, 49)
				.noneMatch(temp -> temp > 55);
		System.out.println("noneMatch(temp -> temp > 55): " + noneMatch);
	}

	private static void searchClassMethodNames() {
		Method[] methods = Stream.class.getMethods();
		Optional<String> methodName = Arrays.stream(methods)
				.map(method -> method.getName())
				.filter(name -> name.endsWith("Match")).sorted().findFirst();
		System.out.println("First Method name : " + methodName.orElse("No similar method found"));
	}
	private static void lazyProcess() {
		ArrayList<String> fruitList = new ArrayList<>();
		fruitList.add("Mango"); fruitList.add("Pine apple");
		fruitList.add("Guava"); 	fruitList.add("Orange");
		fruitList.add("Apricot"); 	fruitList.stream() // nothing gets printed above without terminal operation
				.filter(s -> { 	System.out.println("Filter: " + s);
					return true; });
		System.out.println("Nothing printed as no Terminal Operation");
		System.out.println();
		fruitList.stream() // nothing gets printed unless there is a terminal operation
				.filter(s -> s.endsWith("e")).filter(s -> s.startsWith("P"))
				.forEach(System.out::println);
	}
	private static void cannotReuseStream() {
		System.out.println("*** Reuse / Reopening Stream - throws error  ***");
		Stream<String> stream1 = Stream.of("a1", "a2", "b1", "b3", "c4")
				.filter(s -> s.startsWith("a"));
		stream1.anyMatch(s -> s == "a1");
		// stream1.noneMatch(s->true); // Error raised here
	}

	private static void ProcFlowAndSortExecution() {
		// Sort operation (This is a executed horizontally, not like other
		// operations
		System.out.println("Sort Operation horizontal execution - all input is "
				+ "processed before next operation");
		Stream.of("Ann", "Alfred", "Barry", "Bing", "Charlie").sorted((s1, s2) -> {
			System.out.printf("Sort %s, %s \n", s1, s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("Filter " + s);
			return s.startsWith("A");
		}).map(s -> {
			System.out.println("Map :" + s);
			return (s.toLowerCase());
		}).forEach(s -> System.out.println("forEach - Final Output: " + s));
	}

	private static void supplierGet() {
		Supplier<String> helloStrSupplier = () -> new String("Hello");
		String helloStr = helloStrSupplier.get();
		System.out.println("String in helloStr is->" + helloStr + "<-");
	}

	private static void infiniteStream() {
		System.out.println("\n*** Infinite Streams with generate() & Iterate***");
		Stream.generate(new Random()::nextDouble).limit(4).forEach(System.out::println);

		IntStream.iterate(0, i -> i + 2).limit(50).forEach(System.out::print);
		
	    System.out.println("Sum of First 100 integers");
	    Integer sum = IntStream.iterate(1, i->i+1).limit(100).reduce(0,(x, y) -> x + y); 
	    System.out.println("Sum of First 100 elements is: " + sum);
	}

	private static void bigIntIterate() {
		BigInteger bigInt = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(100)
				.reduce(BigInteger.ZERO, (b1, b2) -> b1.add(b2));
		System.out.println("\nSum of first 100 integers is: " + bigInt.toString());
		System.out.println();
	}

	private static void mathOps() {
		// max method definition :- Optional<T> max(Comparator<? super T>
		// comparator);
		Stream<Double> prices = Stream.of(24.5, 23.6, 27.9, 21.1, 23.5, 25.5, 28.3);
		Optional<Double> max = prices.max(Double::compareTo);
		if (max.isPresent()) {
			System.out.println("Max price is: " + max.get());

			// min & count
			String[] string = "you never know what you have until you clean your room !!".split(" ");
			System.out.println(Arrays.stream(string).min(String::compareTo).get());
			System.out.println(Arrays.stream(string).count());
			System.out.println();

			// more methods like summaryStatistics available
		}
	}

	private static void sortedWordList() {
		List<String> words = Arrays.asList("follow your heart but take your brain with you"
				.split(" "));
		words.stream().distinct().sorted().forEach(System.out::println);
	}

	private static void reduceExample() {
		// Getting factorial
		System.out.println("Factorial is: " + IntStream.rangeClosed(1, 5)
		.reduce((x, y) -> (x * y)).getAsInt());
		System.out.println("Sum is    : " + IntStream.of(10, 20, 30, 40, 50, 60)
		.sum());
		int total = IntStream.of(10, 20, 30, 40, 50, 60)
				.reduce(0, ((sum, val) -> sum + val));
		System.out.println("Same Sum  : " + total);
		System.out.println();
		String str1 = Stream.of("a1", "a2", "b1", "b3", "c4")
				.reduce("", ((s, e) -> s + e));
		System.out.println(str1);
		
		Stream.iterate(1L, i -> i + 1)
			.limit(100)
			.reduce(0L, Long::sum);
		Stream.iterate(1L, i -> i + 1)
			.limit(100)
			.parallel()
			.reduce(0L, Long::sum);	
	}
	private static void flatMapExample() {
		System.out.println("Flat map example - 1");
		String[] words = "you never know what you have until you clean your room".split(" ");
		Arrays.stream(words)
	//		 .map(word -> Arrays.stream(word.split(""))) // try uncomment
	//			 this and comment below line
				.flatMap(word -> Arrays.stream(word.split(""))).distinct()
				.forEach(System.out::print);
		System.out.println();

		// List of Lists, use Flat map to flatten
		System.out.println("Flat map example 2");
		List<List<Integer>> intsOfInts = 
				Arrays.asList(Arrays.asList(1, 3, 5), Arrays.asList(2, 4));
		intsOfInts.stream().flatMap(ints -> ints.stream()).sorted().
			map(i -> i * i).map(i->i + " ").forEach(System.out::print);
		System.out.println();
	}

	private static void collectExamples() {
		// Collect to a List
		String[] roseQuote = "a rose is a rose is a rose".split(" ");
		List<String> words = Arrays.stream(roseQuote).collect(Collectors.toList());
		words.forEach(System.out::println);
		System.out.println();
		// To Map -- map key, value
		Map<String, Integer> nameLength = Stream.of("Arnold", "Alois", "Schwarzenegger")
				.map(s -> s.toUpperCase())
				.collect(Collectors.toMap(name -> name, name -> name.length()));

		nameLength.forEach((name, len) -> System.out.printf("%s - %d \n", name, len));
		System.out.println();
	}
	private static void partitionBy() {
		// Grouping
		System.out.println("***** Grouping ****");
		String[] string = "you never know what you have until you clean your room".split(" ");
		Stream<String> distinctWords = Arrays.stream(string).distinct();
		Stream<String> distinctWordsagain = Arrays.stream(string).distinct();
		Map<Integer, List<String>> wordGroups = 
				distinctWords.collect(Collectors.groupingBy(String::length));
		wordGroups.forEach((count, words) -> {
			System.out.printf("word(s) of length %d", count);
			words.forEach(System.out::println);
		});

		// Partitioning
		Map<Boolean, List<String>> wordBlocks = distinctWordsagain
				.collect(Collectors.partitioningBy(str -> str.length() > 4));
		System.out.println("Short words (len <= 4): " + wordBlocks.get(false));
		System.out.println("Long words (len > 4): " + wordBlocks.get(true));

	}

	private static void parallelExample() {
		System.out.println( "No of Processors - "+ Runtime.getRuntime().availableProcessors());
		IntStream.rangeClosed(1, 100).parallel().
		   filter(i -> i % 2 == 1).forEach(System.out::print);
		System.out.println();  //rangeClosed 1-100, range -> 1 to 99
	}

	private static void parallelReduce() {
		String words[] = "the quick brown fox jumps over the lazy dog".split(" ");
		String originalString =
		(Arrays.stream(words).parallel().reduce("", (a, b) -> a + " " + b));
		System.out.println(originalString);
		
		// Parallel Reduce non-associative
		System.out.println("Parallel Stream reducion - non-associative");
		System.out.println(Arrays.asList(1,2,3,4,5,6)
				.parallelStream()
				.reduce(0,(a,b) -> (a-b)));
	}
	
	private static void fileIO() {
		Path path = Paths.get("C:\\temp\\test.txt");
		Stream<String> streamOfWords = Stream.empty();
		try {
			streamOfWords = Files.lines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		streamOfWords.forEach(System.out::println);

	}

	private static void parallelStreamWithCombiner() {
		int length = Arrays.asList("one", "two","three","four")
		        .parallelStream()
		        .reduce(0,
		                (accumulatedInt, str) -> accumulatedInt + str.length(),                 //accumulator
		                (accumulatedInt, accumulatedInt2) -> accumulatedInt + accumulatedInt2); //combiner		
		System.out.println("Length of All Strings - ParallelStream: " + length);
	
	}
	
	private static void forEachOrdered() {
		
		Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12)
		     .parallelStream().
		     forEach(System.out::println);
		
		Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12)
	     .parallelStream().
	     forEachOrdered(System.out::println);
	
	}
	
}
