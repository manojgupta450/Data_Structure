package com.manu.java8.FunctionalProgram;

public class MyMain {

	public static void main(String[] args) {
		Adder sum = (x,y) -> x+y;    //Assignment target type
		System.out.println(sum.compute(10, 12));
	}

}
