package com.manu.java8.FunctionalProgram.FunctionTest;

import java.util.*;
import java.util.function.Function;

//Function is a functional interface; it takes an argument (object of type T) and returns an object (object of type R).
// The argument and output can be a different type.
// T – Type of the input to the function.
// R – Type of the result of the function.
public class FunctionTest {

    public static void main(String[] args) {
        Function<String, Integer> func = x -> x.length();
        Integer apply = func.apply("mkyong");   // 6
        System.out.println(apply);


        Function<String, Integer> func1 = x -> x.length();
        Function<Integer, Integer> func2 = x -> x * 2;
        Integer result = func1.andThen(func2).apply("mkyong");   // 12
        System.out.println(result);

        List<String> list = Arrays.asList("node", "c++", "java", "javascript");
        Map<String, Integer> map1 = convertListToMap(list, x -> x.length());
        System.out.println(map1);    // {node=4, c++=3, java=4, javascript=10}

        System.out.println("method reference");
        Map<String, Integer> map2 = convertListToMap(list, FunctionTest::getLength);
        System.out.println(map2);

        System.out.println("sha256 using function");
        List<String> stringList = Arrays.asList("node", "c++", "java", "javascript");
        List<String> resultList = mapToList(stringList, FunctionTest::sha256);
        resultList.forEach(System.out::println);
    }

    private static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> function) {
        Map<T, R> map = new HashMap<>();
        for (T t : list) {
            map.put(t, function.apply(t));
        }
        return map;
    }

    public static Integer getLength(String str) {
        return str.length();
    }

    public static <T, R> List<R> mapToList(List<T> list, Function<T, R> func) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(func.apply(t));
        }
        return result;
    }

    // sha256 a string
    public static String sha256(String str) {
        return str + Math.random();
    }
}
