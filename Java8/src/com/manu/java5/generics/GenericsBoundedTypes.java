package com.manu.java5.generics;


// <T extends A> This means T can only accept data that are subtypes of A.
public class GenericsBoundedTypes<T extends Number> {

    public void display(T obj) {
        System.out.println("This is a bounded type generics class " + obj.getClass().getName() + " = " + obj);
    }

    public static void main(String[] args) {
        // Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'
        //GenericsBoundedTypes<String> obj = new GenericsBoundedTypes<>();
        GenericsBoundedTypes<Integer> obj = new GenericsBoundedTypes<>();
        obj.display(10);

        GenericsBoundedTypes<Long> obj1 = new GenericsBoundedTypes<>();
        obj1.display(10L);

        GenericsBoundedTypes<Float> obj2 = new GenericsBoundedTypes<>();
        obj2.display(10.998F);

        GenericsBoundedTypes<Double> obj3 = new GenericsBoundedTypes<>();
        obj3.display(10.99833);

        GenericsBoundedTypes<Number> obj4 = new GenericsBoundedTypes<>();
        obj4.display(10.99833f);

        GenericsBoundedTypes<Number> obj5 = new GenericsBoundedTypes<>();
        obj5.display(10);
    }
}
