package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Csa {
	 
    public static void main(String[] args){
        Parent p = new Child();
        p.testMethod();
    }
}
 
class Parent{
    public IOException testMethod()
    {
        System.out.println("Parent");
        return new IOException();
    }
}
 
class Child extends Parent{
    public FileNotFoundException testMethod() 
    {
        System.out.println("Child");
        return new FileNotFoundException();
    }
}