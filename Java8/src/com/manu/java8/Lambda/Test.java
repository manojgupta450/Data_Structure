package com.manu.java8.Lambda;


// Java program to demonstrate lambda expressions
// to implement a user defined functional interface.

// A sample functional interface (An interface with
// single abstract method
interface FuncInterface
{
    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function
    default void normalFun()
    {
        System.out.println("Hello");
    }
}

class Test
{
    public static void main(String args[])
    {
        // lambda expression to implement above
        // functional interface. This interface
        // by default implements abstractFun()
        FuncInterface fObj = (int x) -> {
            System.out.println(2 * x);
        };

        FuncInterface fObj1 = (int x) -> System.out.println(2 * x);
        FuncInterface fObj2 = (x) -> System.out.println(2 * x);
        FuncInterface fObj3 = x -> System.out.println(2 * x);
        FuncInterface fObj4 = x -> getPrintln(x);
        FuncInterface fObj5 = Test::getPrintln;


        // This calls above lambda expression and prints 10.
        fObj.abstractFun(5);
        fObj1.abstractFun(6);
        fObj2.abstractFun(7);
        fObj3.abstractFun(8);
        fObj4.abstractFun(9);
        fObj5.abstractFun(10);
    }

    private static void getPrintln(int x) {
        System.out.println(2 * x);
    }
}
