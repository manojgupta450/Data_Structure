package com.manu.thread;

import java.util.concurrent.CountDownLatch;


/*Pseudo code for CountDownLatch can be written like this:

- Main thread start
- Create CountDownLatch for N threads
- Create and start N threads
- Main thread wait on latch
- N threads completes their tasks and count down the latch
- Main thread resume execution
https://howtodoinjava.com/java/multi-threading/when-to-use-countdownlatch-java-concurrency-example-tutorial/

CountDownLatch starts with a fixed number of counts which cannot be changed later,
though this restriction is re-mediated in Java 7 by introducing a similar but flexible concurrency utility called Phaser.

*/

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Worker worker1 = new Worker(2000, countDownLatch);
        Worker worker2 = new Worker(5000, countDownLatch);
        Worker worker3 = new Worker(6000, countDownLatch);
        Worker worker4 = new Worker(7000, countDownLatch);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        try {
            System.out.println("Count before await = " + countDownLatch.getCount());

            countDownLatch.await();

            System.out.println("Count after await = " + countDownLatch.getCount());
            System.out.println("Count down latch completed");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Worker extends Thread {

    long timeInMs;
    CountDownLatch countDownLatch;
    public Worker(long timeInMs, CountDownLatch countDownLatch) {
        this.timeInMs = timeInMs;
        this.countDownLatch = countDownLatch;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Waiting.");
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        countDownLatch.countDown();

        System.out.println(Thread.currentThread().getName() + " is Completed.");
    }
}