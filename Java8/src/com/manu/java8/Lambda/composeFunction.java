package com.manu.java8.Lambda;

import java.util.function.Function;

public class composeFunction {
		//  Use java.util.function.Function & lambdas to compose 
		//  set the base function with lambda           
		//  compose() method with before function parameter
		//  andThen() method with after function parameter
		//  Call before.apply() or after.apply() as needed    

	public static void main(String[] args) {
		Function<Integer, Integer> baseFunction = t -> t + 2;
		Function<Integer, Integer> afterFunction = baseFunction.andThen(t -> t * 3);
		System.out.println("After Function Apply : " + afterFunction.apply(5));
		System.out.println("Base Function Apply : " + baseFunction.apply(5) );

		Function<Integer, Integer> beforeFunction = baseFunction.compose(t -> t * 3);
		System.out.println("Before Function Apply : " + beforeFunction.apply(5));



	}

}
