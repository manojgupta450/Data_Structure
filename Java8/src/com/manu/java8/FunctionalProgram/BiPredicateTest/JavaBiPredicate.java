package com.manu.java8.FunctionalProgram.BiPredicateTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

//BiPredicate is a functional interface, which accepts two arguments and returns a boolean,
//basically this BiPredicate is same with the Predicate, instead, it takes 2 arguments for the test.
public class JavaBiPredicate {
    public static void main(String[] args) {

        //0.
        biPredicateIntiolizationWays();

        //1.Simple predicate for checking equality And greater than
        biPredicateWithTest();

        //2.
        biPredicateWithTestNFilter();

        //3.
        biPredicateWithAnd();

        //4.
        biPredicateWithOR();

        //5.
        biPredicateWithNegate();

        //6.
        biPredicateWithUserDefinedObject();

    }


    public static <T extends Domain> List<T> filterBadDomain(List<T> list, BiPredicate<String, Integer> biPredicate) {
        return list.stream()
                .filter(x -> biPredicate.test(x.getName(), x.getScore()))
                .collect(Collectors.toList());
    }

    private static void biPredicateIntiolizationWays() {
        BiPredicate<String, Integer> biPredicateFilter = (x, y) -> {
            return x.length() == y;
        };

        BiPredicate<String, Integer> biPredicateFilter1 = (x, y) -> x.length() == y;
    }

    private static void biPredicateWithTest() {
        System.out.println("Predicate With Test");
        BiPredicate<String, Integer> biPredicateFilter = (x, y) -> x.length() == y;
        boolean result = biPredicateFilter.test("Manoj", 5);
        System.out.println(result);
        boolean result1 = biPredicateFilter.test("Vivek", 4);
        System.out.println(result1);

        // Simple predicate for checking equality
        BiPredicate<Integer, String> biPredicate = (n, s) -> {
            if (n == Integer.parseInt(s))
                return true;
            return false;
        };
        System.out.println(biPredicate.test(2, "2"));
        System.out.println(biPredicate.test(2, "3"));

        // Predicate for checking greater than
        BiPredicate<Integer, String> biPredicate1 = (n, s) -> n > Integer.parseInt(s);
        System.out.println(biPredicate1.test(5, "3"));
        System.out.println(biPredicate1.test(3, "5"));
    }

    private static void biPredicateWithTestNFilter() {
        System.out.println("Predicate With TestNFilter");
        List<String> list = Arrays.asList("Ram", "Shyam", "Jack", "Sam");
        BiPredicate<String, Integer> biPredicateFilter = (x, y) -> x.length() == y;
        list.stream().filter( x -> biPredicateFilter.test(x, x.length())).collect(Collectors.toList()).forEach(System.out::println); //Ram, Shyam, Jack, Sam
        list.stream().filter( x -> biPredicateFilter.test(x, 5)).collect(Collectors.toList()).forEach(System.out::println); //Shyam
        list.stream().filter( x -> biPredicateFilter.test(x, 4)).collect(Collectors.toList()).forEach(System.out::println); //Jack
        list.stream().filter( x -> biPredicateFilter.test(x, 3)).collect(Collectors.toList()).forEach(System.out::println); //Ram, Sam
    }

    private static void biPredicateWithAnd() {
        System.out.println("Predicate With AND");
        BiPredicate<Integer, Integer> bp1 = (n1, n2) -> n1 % n2 == 0;
        BiPredicate<Integer, Integer> bp2 = (n1, n2) -> n1 * n2 > 100;
        // n1 should divisible by n2 and n1*n2 greater than 100
        System.out.println(bp1.and(bp2).test(120, 7)); // false
        System.out.println(bp1.and(bp2).test(120, 10)); // true
        BiPredicate<String, String> bp3 = (s1, s2) -> s1.startsWith(s2);
        BiPredicate<String, Integer> bp4 = (s1, s2) -> s1.length() > s2;
        BiPredicate<String, String> bp5 = (s1, s2) -> s1.endsWith(s2);
        //System.out.println(bp3.and(bp4).test("ANAND", "D")); // incompatible types
        // s1 should starts with "P" and ends with "P"
        System.out.println(bp3.and(bp5).test("Peter", "P")); // false
        // s1 should starts with "A" and end with "A"
        System.out.println(bp3.and(bp5).test("ASHJA", "A")); // true
    }

    private static void biPredicateWithOR() {
        System.out.println("Predicate With OR");
        BiPredicate<Integer, Integer> bp1 = (n1, n2) -> (n1 % n2 == 0);
        BiPredicate<Integer, Integer> bp2 = (n1, n2) -> (n1 * n2 > 100);
        // n1 should be divisible by n2 or greater than 100
        System.out.println(bp1.or(bp2).test(120, 7)); // true
        System.out.println(bp1.or(bp2).test(14, 7)); // true
        System.out.println(bp1.or(bp2).test(12, 10)); // true
        System.out.println(bp1.or(bp2).test(13, 5)); // false
        BiPredicate<String, String> bp3 = (s1, s2) -> s1.startsWith(s2);
        BiPredicate<String, Integer> bp4 = (s1, s2) -> s1.length() > 5;
        BiPredicate<String, String> bp5 = (s1, s2) -> s1.endsWith(s2);
        // name starts with "A" or not ends with "p"
        // System.out.println(bp3.or(bp4)); // bp3 and bp4 are incompatible types
        System.out.println(bp3.or(bp5).test("Peter", "r")); // true
        System.out.println(bp3.or(bp5).test("Anand", "A")); // true
        System.out.println(bp3.or(bp5).test("Manoj", "r")); // false
    }

    private static void biPredicateWithNegate() {
        System.out.println("Predicate With negate");
        BiPredicate<Integer, Integer> bp1 = (n1, n2) -> (n1 % n2 == 0);
        BiPredicate<Integer, Integer> bp2 = (n1, n2) -> (n1 * n2 > 100);
        // n1 should not be divisible by n2 and n1*n2 not greater than 100
        System.out.println(bp1.negate().test(120, 6)); // false
        System.out.println(bp1.negate().test(120, 7)); // true
        System.out.println(bp2.negate().test(12, 7)); // true
        BiPredicate<String, String> bp3 = (s1, s2) -> s1.startsWith(s2);
        BiPredicate<String, Integer> bp4 = (s1, s2) -> s1.length() > s2;
        BiPredicate<String, String> bp5 = (s1, s2) -> s1.endsWith(s2);
        // s1 should not start with s2
        System.out.println(bp3.negate().test("ANAND", "D")); // true
        // s1 length should not greater than s2
        System.out.println(bp4.negate().test("PETER", 5)); // true
        // s1 should not end with s2
        System.out.println(bp5.negate().test("ASHJA", "A")); // false
    }

    private static void biPredicateWithUserDefinedObject() {
        System.out.println("Predicate With User defined Object");
        List<Domain> domains = Arrays.asList(
                new Domain("google.com", 1),
                new Domain("i-am-spammer.com", 10),
                new Domain("mkyong.com", 0),
                new Domain("microsoft.com", 2));

        BiPredicate<String, Integer> bi = (domain, score) -> (domain.equalsIgnoreCase("google.com") || score == 0);

        // if google.com or score == 0
        List<Domain> result = filterBadDomain(domains, bi);
        System.out.println(result); // google.com, mkyong.com

        //  if score == 0
        List<Domain> result2 = filterBadDomain(domains, (domain, score) -> score == 0);
        System.out.println(result2); // mkyong.com

        // if start with i or score > 5
        List<Domain> result3 = filterBadDomain(domains, (domain, score) -> domain.startsWith("i") && score > 5);
        System.out.println(result3); // i-am-spammer.com

        // chaining with or
        List<Domain> result4 = filterBadDomain(domains, bi.or((domain, x) -> domain.equalsIgnoreCase("microsoft.com")));
        System.out.println(result4); // google.com, mkyong.com, microsoft.com
    }

}
