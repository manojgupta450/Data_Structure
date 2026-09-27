package com.manu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class CyclicBarrierTest {
    static int threadCount = 5;
    static ExecutorService executorService = Executors.newFixedThreadPool(5);
    static Phaser phaser = new Phaser(0);

    public static void main(String[] args) {
        while(threadCount > 0) {
            phaser.register();
            System.out.println("Registered Parties " + phaser.getRegisteredParties());
            executorService.submit(new CopyTask1(phaser, threadCount, 1000));
            threadCount--;
        }
        //phaser.arriveAndAwaitAdvance(); or below
        try {
            phaser.arriveAndAwaitAdvance();
            //phaser.awaitAdvanceInterruptibly(phaser.getUnarrivedParties(), 5, TimeUnit.SECONDS);
        } /*catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }*/
        finally {
            System.out.println("All parties arrived " + phaser.getArrivedParties());
            phaser.forceTermination();
        }

    }

}

class CopyTask1 extends Thread {
    Phaser phaser;
    int threadCount;
    long timeInMs;

    public CopyTask1(Phaser phaser, int threadCount, long timeInMs) {
        this.phaser = phaser;
        this.threadCount = threadCount;
        this.timeInMs = timeInMs;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " completed");
        phaser.arriveAndDeregister();
    }
}

