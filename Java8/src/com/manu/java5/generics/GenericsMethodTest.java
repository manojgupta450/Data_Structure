package com.manu.java5.generics;

public class GenericsMethodTest {
    static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }

    public static < T > void printGenericArray(T[] items) {
        for ( T item : items){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        genericDisplay(11);
        genericDisplay("GeeksForGeeks");
        genericDisplay(1.0);

        Integer[] int_Array = { 1, 3, 5, 7, 9, 11 };
        Character[] char_Array = { 'J', 'A', 'V', 'A', 'T','U','T','O','R','I','A', 'L','S' };

        System.out.println( "Integer Array contents:" );
        printGenericArray(int_Array);

        System.out.println( "Character Array contents:" );
        printGenericArray(char_Array);
    }
}
