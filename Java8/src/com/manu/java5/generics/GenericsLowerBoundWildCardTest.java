package com.manu.java5.generics;

import java.util.Arrays;
import java.util.List;

//Lower bounded wildcards is to restrict the unknown type to be a specific type(same type) or a supertype of that type
public class GenericsLowerBoundWildCardTest {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3);
        System.out.println("displaying the Integer values");
        addNumbers(integerList);

        List<Number> numberList = Arrays.asList(1.0,2.0,3.0);
        System.out.println("displaying the Number values");
        addNumbers(numberList);
    }

    public static void addNumbers(List<? super Integer> list) {
        for(Object n:list) {
            System.out.println(n);
        }
    }
}
