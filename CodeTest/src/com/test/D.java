package com.test;

interface Out{
public void a();
interface In{
	public void a();
}
}

public class D implements Out.In,Out{
	public void a() {
		System.out.println("Inner");
		
	}
	public static void main(String args[]) {
	D d=new D();
	d.a();
	}
}
