package com.manu.java8.FunctionalProgram.ConsumerTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// Consumer is a functional interface; it takes an argument and returns nothing.
public class ConsumerTest {

    public static void main(String[] args) {
        System.out.println("Consumer simple test ");
        Consumer<String> print = x -> System.out.println(x);
        print.accept("java");   // java

        System.out.println("Consumer test arraylist ");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> consumer = x -> System.out.println(x);
        printForEach(list, consumer); // Or
        printForEach(list, x -> System.out.println(x));

        System.out.println("Printing list's element length using consumer");
        List<String> stringList = Arrays.asList("a", "ab", "abc");
        printForEach(stringList, y -> System.out.println(y.length()));
    }

    private static <T> void printForEach(List<T> list, Consumer<T> consumer) {
        for (T i : list) {
            consumer.accept(i);
        }

    }
}
