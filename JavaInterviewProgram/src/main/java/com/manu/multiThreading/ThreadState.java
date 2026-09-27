package com.manu.multiThreading;

public class ThreadState {
    public static Thread thread1;
    public static Thread1 thread1Obj;

    public static void main(String argvs[]) {
        thread1Obj = new Thread1();
        thread1 = new Thread(thread1Obj);
        System.out.println("The state of thread t1 after spawning it - " + thread1.getState()); //NEW
        thread1.start();
        System.out.println("The state of thread t1 after invoking the method start() on it - " + thread1.getState()); //RUNNABLE
    }
}

class Thread1 implements Runnable {
    public void run() {
        Thread2 thread2Obj = new Thread2();
        Thread thread2 = new Thread(thread2Obj);

        System.out.println("The state of thread thread2 after spawning it - "+ thread2.getState()); //NEW
        thread2.start();
        System.out.println("the state of thread thread2 after calling the method start() on it - " + thread2.getState()); //RUNNABLE

        try {
            // moving the thread thread1 to the state timed waiting// current tread is thread1
            Thread.sleep(200);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("The state of thread thread2 after invoking the method sleep() on it - "+ thread2.getState()); //TIMED_WAITING

        try {
            thread2.join(); //Waits for this thread to die.
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("The state of thread thread2 when it has completed it's execution - " + thread2.getState()); //TERMINATED
    }
}

class Thread2 implements Runnable {
    public void run() {

        try {
            //Current thread is thread2 and it's less than 200ms
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("The state of thread t1 while it invoked the method join() on thread t2 -" + ThreadState.thread1.getState()); //TIMED_WAITING

        try {
            //Current thread is thread2, sleeping for 200ms
            Thread.sleep(200);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
