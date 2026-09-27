package com.manu.java8.FunctionalProgram.PredicateTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//In Java 8, Predicate is a functional interface, which accepts an argument and returns a boolean.
// Usually, it used to apply in a filter for a collection of objects.
public class Java8Predicate {

    public static void main(String[] args) {

        //0. Ways of initializing predicate
        predicateInitiolizationWays();

        //1. filter() accepts predicate as argument.
        predicateInFilter();

        //2.  Predicate.and() having Multiple filters.
        predicateWithAnd();

        //3. Predicate.or()
        predicateWithOr();

        //4. Predicate.negate() Find all elements not start with ‘A’.
        predicateWithNegate();

        //5. Predicate.test() -- Predicate in function.
        predicateWithTestInFunction();

        //6. Predicate Chaining
        predicateChaining();

        //7. Predicate in Object
        predicateInObject();

        //8. anyMatch(), allMatch(), noneMatch() accepts predicate as argument.
        predicateInAnyAllNone();

        //9. IntPredicate DoublePredicate
        IntAndDoublePredicate();
    }

    private static void IntAndDoublePredicate() {
        System.out.println("---------");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntPredicate intPredicate = x -> x > 5;

        System.out.println("IntPredicate in filter");
        integerList.stream().mapToInt(Integer::intValue).filter(intPredicate).forEach(System.out::print);
        System.out.println();
        System.out.println("---------");
        integerList.stream().mapToInt(Integer::intValue).filter(intPredicate).max().ifPresent(System.out::print);
        System.out.println("\n ** 6 - DoubleStream to IntStream to Object Stream transform **");
        Stream.of(10.0,20.7,30.0,40.5).mapToInt(Double::intValue).mapToObj(i->"a"+i).forEach(System.out::println);

        System.out.println("---------");
        List<Double> doublesList = Arrays.asList(10.5, 23.4, 30.0, 40.2, 10.0);
        DoublePredicate doublePredicate = x -> x > 11.0;
        doublesList.stream().mapToDouble(Double::intValue).filter(doublePredicate).forEach(System.out::println);
        System.out.println("---------");
        doublesList.stream().mapToDouble(Double::floatValue).filter(doublePredicate).forEach(System.out::println);
        System.out.println("---------");
        doublesList.stream().mapToDouble(Double::doubleValue).filter(doublePredicate).forEach(System.out::println);
    }

    private static void predicateInitiolizationWays() {
        Predicate<String> predicateFilter = (x) -> {
            return x.length() == 5;
        };
        Predicate<String> predicateFilter1 = (x) -> x.length() == 5;
        Predicate<String> predicateFilter2 = x -> x.length() == 5;
    }

    private static void predicateInFilter() {

        System.out.println("Predicate In Filter");
        //1.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collectedList = list.stream().filter(x -> x > 5).collect(Collectors.toList());
        System.out.println(collectedList);

        //2. Replace with Predicate.and()
        Predicate<Integer> noGreaterThan5 = x -> x > 5;
        List<Integer> collectedList1 = list.stream().filter(noGreaterThan5).collect(Collectors.toList());
        System.out.println(collectedList1);

        //3.
        list.stream().filter(noGreaterThan5).forEach(System.out::print);

        //4.
        list.stream().filter(noGreaterThan5).forEach(System.out::println);

        //5.
        list.stream().filter(noGreaterThan5).forEach(Java8Predicate::print);
        System.out.println();
    }

    private static void predicateWithAnd() {
        System.out.println("Predicate.and()");
        //1.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().filter(x -> x > 5 && x < 8).collect(Collectors.toList()).forEach(System.out::println);

        //2.
        Predicate<Integer> noGreaterThan5 = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;
        list.stream().filter(noGreaterThan5.and(noLessThan8)).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void predicateWithOr() {
        System.out.println("Predicate.or()");
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");
        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        list.stream().filter(lengthIs3.or(startWithA)).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void predicateWithNegate() {
        System.out.println("Predicate.negate()");
        Predicate<String> startWithA = x -> x.startsWith("A");
        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        list.stream().filter(startWithA.negate()).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void predicateWithTestInFunction() {
        System.out.println("Predicate.test()");
        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        System.out.println(StringProcessor.filter(list, x -> x.startsWith("A")));                    // [A, AA, AAA]
        System.out.println(StringProcessor.filter(list, x -> x.startsWith("A") && x.length() == 3)); // [AAA]
        System.out.println(StringProcessor.filter(list, x -> x.startsWith("A") || x.length() == 3));
    }

    private static void predicateChaining() {
        System.out.println("Predicate Chaining");
        Predicate<String> startWithA = x -> x.startsWith("a");

        // start with "a" or "m"
        boolean result = startWithA.or(x -> x.startsWith("m")).test("mkyong");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWithA.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);    // false

        // !(start with "a" and length is 3)
        boolean result3 = startWithA.and(x -> x.length() == 3).negate().test("ab");
        System.out.println(result3);    // true
    }

    private static void predicateInObject() {
        System.out.println("Predicate In Object");
        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");

        List<Hosting> list = Arrays.asList(new Hosting[]{h1, h2, h3, h4});

        List<Hosting> result = HostingRespository.filterHosting(list, x -> x.getName().startsWith("g"));
        System.out.println("result : " + result);  // google

        List<Hosting> result2 = HostingRespository.filterHosting(list, isDeveloperFriendly());
        System.out.println("result2 : " + result2); // linode
    }

    public static Predicate<Hosting> isDeveloperFriendly() {
        return n -> n.getName().equals("linode");
    }

    private static void predicateInAnyAllNone() {
        System.out.println("Predicate In anyMatch");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().anyMatch(x -> x == 11));
        System.out.println(list.stream().anyMatch(x -> x == 5));
        System.out.println(list.stream().anyMatch(x -> x > 5));

        System.out.println("Predicate In allMatch");
        System.out.println(list.stream().allMatch(x -> x == 5));
        System.out.println(list.stream().allMatch(x -> x > 5));
        System.out.println(list.stream().allMatch(x -> x > 0));

        System.out.println("Predicate In noneMatch");
        System.out.println(list.stream().noneMatch(x -> x == 11));
        System.out.println(list.stream().noneMatch(x -> x > 5));
        System.out.println(list.stream().noneMatch(x -> x < 0));
    }

    private static void print(Integer integer) {
        System.out.print(integer);
    }
}

class StringProcessor {
    static List<String> filter(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate::test).collect(Collectors.toList());
    }
}
