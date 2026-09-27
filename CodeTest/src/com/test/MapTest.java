package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

public class MapTest {

	public static void main(String[] args) {
		CountDownLatch latch=new CountDownLatch(4);
		MyThread my=new MyThread(latch,"Thread1",100L);
		MyThread my1=new MyThread(latch,"Thread2",200L);
		MyThread my2=new MyThread(latch,"Thread3",300L);
		MyThread my3=new MyThread(latch,"Thread4",400L);
		
		my.start();
		my1.start();
		my2.start();
		my3.start();
		
		System.out.println(latch.getCount());
		
		
		try {
			latch.await();
			System.out.println("Counter reached");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			

		
		/*HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		
		Iterator<Entry<Integer,String>> entry=map.entrySet().iterator();
		while (entry.hasNext()) {
			Entry<Integer,String> e=entry.next();
			System.out.println(e.getKey() + " "+ e.getValue());
			entry.remove();
			
		}

		Iterator<Entry<Integer,String>> entry1=map.entrySet().iterator();
		while (entry1.hasNext()) {
			Entry<Integer,String> e=entry1.next();
			System.out.println(e.getKey() + " "+ e.getValue());
		}
*/	}

}


class MyThread extends Thread{
	CountDownLatch latch;
	String message;
	long t;
	public MyThread(CountDownLatch latch, String message, long t) {
		super();
		this.latch = latch;
		this.message = message;
		this.t = t;
	}
	
	public void run() {
		System.out.println(message);
			try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		latch.countDown();	
	}
}