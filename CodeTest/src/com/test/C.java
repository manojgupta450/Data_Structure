package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class C {
	
	public static void main(String args[]) {
		int k = 0;
		for (int i = 0; i < args.length; i++) {
			int j = 0;
			System.out.println(k+j);
		}
		int i=19;
		String s="Manu";
		 Integer sal=200;
		Student st=new Student(20, "Tanu",89039438398L, 100);
		System.out.println(s.hashCode());
		System.out.println(st.hashCode());
		System.out.println(sal.hashCode());
		System.out.println("Inside main() method --->"+Thread.currentThread().getName());
		Student.get();
		Thread t=new Thread(new Test1("User Thread"));
		t.start();
		System.out.println("-----------"+t.getThreadGroup());
		
		List<Integer> li=new ArrayList<Integer>();
		li.add(10);
		li.add(20);
		li.add(30);
		li.add(40);
		
		Iterator<Integer> it=li.iterator();
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
			it.remove();
		}
		

	}
}

class Student {
	private int age;
	private String name;
	private Long phone;
	private Integer sal;
	

	public Student(int age, String name, Long phone, Integer sal) {
		super();
		this.age = age;
		this.name = name;
		this.phone = phone;
		this.sal = sal;
	}
	public static void get() {
		System.out.println("Inside get() method in Student class ---> "+Thread.currentThread().getName());
	}
}

class Test1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Inside run() of Test1 Thread class ---> "+Thread.currentThread().getName());
		
	}
	
	public Test1(String name) {
		System.out.println("Inside Test1() method of Test1 Thread class ---> "+Thread.currentThread().getThreadGroup());
	}
}