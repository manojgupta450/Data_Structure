package com.manu.multiThreading;

public class ThreadTest1 {

    public static void main(String[] args) {
        Thread11 thread11 = new Thread11();
        Thread22 thread22 = new Thread22();
        Thread thread1 = new Thread(thread11);
        Thread thread2 = new Thread(thread22);
        System.out.println("thread1 state before start :" + thread1.getState());
        thread1.start();
        System.out.println("thread1 state after start :" + thread1.getState());


        System.out.println("thread2 state before start :" + thread2.getState());
        thread2.start();
        System.out.println("thread2 state after start :" + thread2.getState());



    }
}

class Thread11 implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(111);
        }
        catch (InterruptedException e) {

        }

        System.out.println("Thread1 state after sleep :" + Thread.currentThread().getName());
    }
}

class Thread22 implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {

        }

        System.out.println("Thread2 state after sleep :" + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {

        }

    }
}
