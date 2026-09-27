package com.manu.thread;

import java.util.concurrent.*;

//https://www.javamadesoeasy.com/2015/03/phaser-in-java_21.html
public class PhaserTest1 {
    static int threadCount = 6;
    static ExecutorService executorService = Executors.newFixedThreadPool(6);
    static Phaser phaser = new Phaser(1);

    public static void main(String[] args) {
        while(threadCount > 0) {
            phaser.register();
            System.out.println("Registered Parties " + phaser.getRegisteredParties());
            executorService.execute(new CopyTask(phaser, threadCount, 1000));
            threadCount--;
            //phaser.arriveAndAwaitAdvance(); or use awaitAdvanceInterruptibly(...)
        }

        phaser.arriveAndDeregister();
        try {
            phaser.awaitAdvanceInterruptibly(phaser.arrive(), 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("All registered parties " + phaser.getArrivedParties());
            System.out.println("All arrived parties" + phaser.getArrivedParties());
            System.out.println("All unarrived parties " + phaser.getUnarrivedParties());
            phaser.forceTermination();
            executorService.shutdown();
        }
    }
}

class CopyTask extends Thread {
    Phaser phaser;
    int threadCount;
    long timeInMs;

    public CopyTask(Phaser phaser, int threadCount, long timeInMs) {
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

