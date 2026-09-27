package com.manu.java5.generics;


// An interface that extends Comparable
interface MinMax<T extends Comparable<T> > {
    T min();
    T max();
}
public class GenericsInterfaceTest<T extends Comparable<T>> implements MinMax<T> {

    T[] values;

    // causes compiler error; Cannot create a generic array of T like below
    //public T[] array = new T[5];
    GenericsInterfaceTest(T[] objects) {
        values = objects;
    }

    @Override
    public T min() {
        T obj = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i].compareTo(obj) < 0) {
                obj = values[i];
            }
        }
        return obj;
    }

    @Override
    public T max() {
        T obj = values[0];

        for (int i = 1; i < values.length; i++)
            if (values[i].compareTo(obj) > 0)
                obj = values[i];
        return obj;
    }

    public static void main(String[] args) {
        Integer arr[] = { 3, 6, 2, 8, 6 };
        GenericsInterfaceTest<Integer> obj1 = new GenericsInterfaceTest<>(arr);
        System.out.println("Minimum value: " + obj1.min());
        System.out.println("Maximum value: " + obj1.max());

        String strArr[] = { "Rajesh", "Ram", "Shyam", "Rahul", "Sunil"};
        GenericsInterfaceTest<String> obj2 = new GenericsInterfaceTest<>(strArr);
        System.out.println("Minimum value: " + obj2.min());
        System.out.println("Maximum value: " + obj2.max());
    }
}


