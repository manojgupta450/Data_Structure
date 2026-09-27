package com.manu.exceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestThrow {

    public static void main(String args[]){
        /*try {
            validate(13);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }*/
        validate(13);
        System.out.println("rest of the code...");

        System.out.println("*************");

        try {
            method();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("rest of the code...");
    }

    //Throwing unchecked exception doesn't need to be propagated to caller by declaring in throws clause
    public static void validate(int age) {
        if(age<18) {
            throw new ArithmeticException("Person is not eligible to vote");
        } else {
            System.out.println("Person is eligible to vote!!");
        }
    }

    //If we throw unchecked exception from a method, It must handle the exception or declare in throws clause.
    public static void method() throws FileNotFoundException {

        FileReader file = new FileReader("C:\\Users\\Anurati\\Desktop\\abc.txt");
        BufferedReader fileInput = new BufferedReader(file);

        throw new FileNotFoundException();

    }


}
