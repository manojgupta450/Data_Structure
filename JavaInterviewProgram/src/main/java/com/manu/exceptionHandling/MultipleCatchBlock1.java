package com.manu.exceptionHandling;

public class MultipleCatchBlock1 {

    //Order of Most specific exception object type will come first in catch
    public static void main(String[] args) {

        try {
            int a[]=new int[5];
            a[5]=30/0;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch(Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");

        System.out.println("++++++++++++++++++++");

        try {
            String s=null;
            System.out.println(s.length());
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception occurs");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        } catch(Exception e) {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }
}