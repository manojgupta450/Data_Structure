package com.manu.exceptionHandling;

public class ExceptionHandlingTest {

    public static void main(String[] args) {
        /*try{
            return;
        } catch (Exception e) {
            System.out.println("Catch");
        }
        finally {
            System.out.println("Finally");
        }*/
        try {
            aMethod();
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println("Finished");

    }

    public static void aMethod() {
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("Finally"); //This ll be printed first
        }
    }

}
