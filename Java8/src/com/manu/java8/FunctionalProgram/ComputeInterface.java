package com.manu.java8.FunctionalProgram;

public interface ComputeInterface {
	void process();
	
	default void compute(double amt) {
		System.out.println("Inside inteface default compute method ");
		System.out.println("Interest" + amt* 1.15);
	}
	default void computeAgain(double amt) {
		System.out.println("Inside inteface default computeAgain method ");
		System.out.println("Interest" + amt* 1.14);
	}		
	
	static int squre(int num) {
	return num*num;
	}
	
}
