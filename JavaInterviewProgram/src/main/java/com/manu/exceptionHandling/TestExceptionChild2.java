package com.manu.exceptionHandling;

// If the superclass method declares an exception,
// subclass overridden method can declare the same, subclass exception or no exception but cannot declare parent exception.
public class TestExceptionChild2 extends Parent1 {

    //Subclass overridden method cannot declare parent exception. Compile time error
    /*void msg() throws Exception {
        System.out.println("child method");
    }*/

    //Subclass overridden method can declare no exception
    /*void msg() {
        System.out.println("child method");
    }*/

    //Subclass overridden method can declare the same exception or subclass exception
    void msg() throws ArithmeticException {
        System.out.println("child method");
    }

    public static void main(String args[]) {
        Parent1 p = new TestExceptionChild2();

        try {
            p.msg();
        }
        catch (Exception e){}

    }
}

class Parent1 {
    void msg()throws ArithmeticException {
        System.out.println("parent method");
    }
}
