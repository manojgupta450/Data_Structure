package com.manu.java8.FunctionalProgram;


public class ThreadTest {

	public static void main(String[] args) {
		new Thread( ()->{
			for(int i=0; i<5; i++) {System.out.println("Thread :"+ i);}
			}).start();
	}

}
