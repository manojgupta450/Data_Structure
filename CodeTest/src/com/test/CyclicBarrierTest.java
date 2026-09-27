package com.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier bar=new CyclicBarrier(4);
		MyThread1 m1=new MyThread1(bar,"Thread1",100L);
		MyThread1 m2=new MyThread1(bar,"Thread2",200L);
		MyThread1 m3=new MyThread1(bar,"Thread3",300L);
		MyThread1 m4=new MyThread1(bar,"Thread4",400L);
		m1.start();
		m2.start();
		m3.start();
		m4.start();
		
		Thread t=new Thread() {
			public void run() {
				System.out.println("All the party has come");
			}
		};
		t.start();
	}

}

class MyThread1 extends Thread{
	CyclicBarrier bar;
	String service;
	long l;
	
	
	public MyThread1(CyclicBarrier bar, String service, long l) {
		super();
		this.bar = bar;
		this.service = service;
		this.l = l;
	}


	public void run() {
		
		try {
			System.out.println(Thread.currentThread().getName() +" " + "is Waiting");
			Thread.sleep(l);
			try {
				bar.await();
				System.out.println(Thread.currentThread().getName() + " "+"Barrier reached");
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
