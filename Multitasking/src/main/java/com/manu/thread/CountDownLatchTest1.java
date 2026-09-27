package com.manu.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Thread cacheService = new Thread(new Service(1000, "CacheService", countDownLatch));
        Thread alertService = new Thread(new Service(2000, "AlertService", countDownLatch));
        Thread validationService = new Thread(new Service(3000, "ValidationService", countDownLatch));
        Thread monitoringService = new Thread(new Service(4000, "MonitoringService", countDownLatch));

        cacheService.start();
        alertService.start();
        validationService.start();
        monitoringService.start();
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

class Service implements Runnable {
    long timeInMs;
    String name;
    CountDownLatch countDownLatch;
    public Service(long timeInMs, String name, CountDownLatch countDownLatch) {
        this.timeInMs = timeInMs;
        this.name = name;
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
