package com.manu.thread;

import java.util.concurrent.Phaser;

//https://www.javamadesoeasy.com/2015/03/phaser-in-java_21.html
public class PhaserTest2 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); //registering the main thread

        int curPhase;
        curPhase = phaser.getPhase();
        System.out.println("Phase in Main " + curPhase + " started");

        // Threads for first phase
        new FileReaderThread("thread-1", "file-1", phaser);
        new FileReaderThread("thread-2", "file-2", phaser);
        new FileReaderThread("thread-3", "file-3", phaser);

        phaser.arriveAndAwaitAdvance();//For main thread

        System.out.println("New phase " + phaser.getPhase() + " started");

        // Threads for second phase
        new QueryThread("thread-1", 40, phaser);
        new QueryThread("thread-2", 40, phaser);
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");

        phaser.arriveAndDeregister();//de-registering the main thread
    }
}

class QueryThread implements Runnable {
    private String threadName;
    private int param;
    private Phaser phaser;

    QueryThread(String threadName, int param, Phaser phaser){
        this.threadName = threadName;
        this.param = param;
        this.phaser = phaser;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + phaser.getPhase());
        System.out.println("Querying DB using param " + param + " Thread " + threadName);
        phaser.arriveAndAwaitAdvance();
        System.out.println("Threads finished");
        phaser.arriveAndDeregister();
    }
}

class FileReaderThread implements Runnable {
    private String threadName;
    private String fileName;
    private Phaser phaser;

    FileReaderThread(String threadName, String fileName, Phaser phaser) {
        this.threadName = threadName;
        this.fileName = fileName;
        this.phaser = phaser;
        phaser.register();
        new Thread(this).start();
    }
    @Override
    public void run() {
        System.out.println("This is phase " + phaser.getPhase());
        try {
            Thread.sleep(20);
            System.out.println("Reading file " + fileName + " thread " + threadName + " parsing and storing to DB ");
            // Using await and advance so that all thread wait here
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
    }
}

