package com.manu.exceptionHandling;

//If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception
// but it can declare unchecked exception.
public class TestExceptionChild1 extends Parent{

    //Subclass overridden method cannot declare the checked exception, gives compile time error
    /*void msg() throws IOException {
        System.out.println("TestExceptionChild");
    }*/

    //Subclass overridden method can declare unchecked exception
    void msg() throws ArithmeticException {
        System.out.println("TestExceptionChild");
    }

    public static void main(String args[]) {
        Parent p = new TestExceptionChild1();
        p.msg();
    }
}

class Parent{
    void msg() {
        System.out.println("parent method");
    }
}