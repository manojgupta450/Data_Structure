package com.manu.java8.FunctionalProgram.BiConsumerTest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

// BiConsumer is a functional interface; it takes two arguments and returns nothing.
public class JavaBiConsumer {

    public static void main(String[] args) {
        System.out.println("Add two numbers");
        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
        addTwo.accept(1, 2);

        System.out.println("Add two items");
        addTwo(1, 2, (x, y) -> System.out.println(x + y));          // 3
        addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js

        System.out.println("Math Operations");
        math(1, 1, (x, y) -> System.out.println(x + y));   // 2
        math(1, 1, (x, y) -> System.out.println(x - y));   // 0
        math(1, 1, (x, y) -> System.out.println(x * y));   // 1
        math(1, 1, (x, y) -> System.out.println(x / y));   // 1

        System.out.println("Map.forEach");
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Java");map.put(2, "C++");map.put(3, "Rust");map.put(4, "JavaScript");map.put(5, "Go");
        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    static <T> void addTwo(T inp1, T inp2, BiConsumer<T, T> biConsumer) {
        biConsumer.accept(inp1, inp2);
    }

    private static <T> void math(T inp1, T inp2, BiConsumer<T, T> biConsumer) {
        biConsumer.accept(inp1, inp2);
    }

}
