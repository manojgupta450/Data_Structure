package com.manu.java8.FunctionalProgram.BiFunctionTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

// BiFunction is a functional interface; it takes two arguments and returns an object.
//T – Type of the first argument to the function.
// U – Type of the second argument to the function.
// R – Type of the result of the function.
public class BiFunctionTest {
    public static void main(String[] args) {

        // 1. BiFunction<T, U, R>
        biFunctionTest();

        //2. BiFunction<T, U, R> + Function<T, R>
        biFunctionWithFunction();


    }

    private static void biFunctionWithFunction() {
        //This BiFunction takes two Integer and returns a Double, and uses andThen() to chain it with a Function to convert the Double into a String.
        // Math.pow(a1, a2) returns Double
        BiFunction<Integer, Integer, Double> biFunction = (a1, a2) -> Math.pow(a1, a2);
        Function<Double, String> function = (input) -> "Result : " + input;
        String result = biFunction.andThen(function).apply(2, 4);
        System.out.println(result);
    }

    private static void biFunctionTest() {
        //This example takes two Integers and returns an Integer, Double or List
        System.out.println("Takes two Integers and return an Integer");
        BiFunction<Integer, Integer, Integer> biFunction = (x1, x2) -> x1 + x2;
        Integer result = biFunction.apply(2, 3);
        System.out.println(result); // 5

        System.out.println("Take two Integers and return an Double");
        BiFunction<Integer, Integer, Double> biFunction1 = (x1, x2) -> Math.pow(x1, x2);
        Double result2 = biFunction1.apply(2, 4);
        System.out.println(result2);    // 16.0

        System.out.println("Take two Integers and return a List<Integer>");
        BiFunction<Integer, Integer, List<Integer>> biFunction2 = (x1, x2) -> Arrays.asList(x1 + x2);
        List<Integer> result3 = biFunction2.apply(2, 3);
        System.out.println(result3);
    }
}
