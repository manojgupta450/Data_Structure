package com.manu.java5.generics;

//We can also pass multiple Type parameters in Generic classes.
public class GenericsClassMultiTypes<T, U> {

    T obj1;
    U obj2;

    GenericsClassMultiTypes(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }

    public static void main (String[] args)
    {
        GenericsClassMultiTypes<String, Integer> obj = new GenericsClassMultiTypes<>("GfG", 15);
        obj.print();
        GenericsClassMultiTypes<Double, Integer> obj1 = new GenericsClassMultiTypes<>(2500.9889, 22);
        obj1.print();
    }
}
