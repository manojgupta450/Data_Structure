package com.test;

//Java code for thread creation by extending
//the Thread class
class MultithreadingDemo extends Thread
{
 public void run()
 {
     try
     {
         // Displaying the thread that is running
         System.out.println ("Thread " +
               Thread.currentThread().getId() + " "+ Thread.currentThread().getName()+ 
               " is running");

     }
     catch (Exception e)
     {
         // Throwing an exception
         System.out.println ("Exception is caught");
     }
 }
}

//Main Class
public class Multithread
{
 public static void main(String[] args)
 {
	 System.out.println(Thread.currentThread().getName());
     //int n = 8; // Number of threads
     for (int i=0; i<5; i++)
     {
         MultithreadingDemo object = new MultithreadingDemo();
         object.start();
     }
 }
}