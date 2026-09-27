package com.test;


import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class Test {
	//private final static ReentrantLock lock = new ReentrantLock();
	
	private Object lock=new Object();
	
	//private final static ReadLock lock1 = new ReadLock(null);
	
	Test obj=new Test();
	
	public void add() throws InterruptedException {
		Test.class.wait();
		obj.wait();
		
		Test.class.notify();
	}

	public static void main(String[] args) {
		Test t=new Test();
		t.lock=new Test();

		
		/*lock.lock();
		System.out.println("Locked");
		lock.unlock();*/

		
	}

}
