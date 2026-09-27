package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class A {
	
	public static void main(String args[]) throws Exception {
		B b=new B();
		
			try {
				System.out.println("jjjj");
				b.a();
				System.out.println("ccc");
			} finally {
				
			}
	}
	
	public void a() throws Exception
	{
		System.out.println("sdh");
		try{
			
		}catch(ArithmeticException e){
			
		}catch(StringIndexOutOfBoundsException e){
			
		}catch(ArrayIndexOutOfBoundsException e){
			
		}catch(IndexOutOfBoundsException e){
			
		}
		
		
	}
	

}

class B extends A{
	public void a() throws Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(bf.readLine());
		throw new Exception();
	}
	
	
}

