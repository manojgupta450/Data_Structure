package com.manu.java5.generics;

import java.util.Arrays;
import java.util.List;

//In Unbounded Wildcards, there are no restrictions on type variables and is denoted as follows: List<?> list
public class GenericsUnBoundWildCardTest {

    //Both the display() methods used for the same purpose
    public static void display(List<?> list) {
        for(Object obj : list) {
            System.out.println(obj);
        }
    }

    /*
    public static <T> void display(List<T> list) {
        for(T obj : list) {
            System.out.println(obj);
        }
    }*/

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1,2,3);
        System.out.println("displaying the Integer values");
        display(l1);
        List<String> l2 = Arrays.asList("One","Two","Three");
        System.out.println("displaying the String values");
        display(l2);
    }
}
