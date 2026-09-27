package com.test;

public class F {
	
	public void methodA() {
		System.out.println("methodA");
	}
	
	public static void main(String args[]) {
		F obj=new G();
		obj.methodA();
	}
}

class G extends F{
	public void methodA() {
		System.out.println("methodA in G");
	}
	
	public void methodB() {
		System.out.println("methodB");
	}
}