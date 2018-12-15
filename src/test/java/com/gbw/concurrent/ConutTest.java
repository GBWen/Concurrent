package com.gbw.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
public class ConutTest {
    private static int count1 = 0;
    private AtomicInteger count2 = new AtomicInteger(0);
    private LongAdder count3 = new LongAdder();
    private static int count4 = 0;
    private volatile static int count5 = 0;

    @Test
    public void myTest() throws InterruptedException {
        final int CLIENT_TOTAL = 5000;
        final int THREAD_TOTAL = 200;
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
        final CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL);
        for (int i = 0; i < CLIENT_TOTAL; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    count1++;
                    count2.getAndAdd(1);
                    count3.add(1);
                    add();
                    count5++;
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception!", e);
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count1 = " + count1);       // < 5000
        log.info("count2 = " + count2.get()); // = 5000
        log.info("count3 = " + count3);       // = 5000
        log.info("count4 = " + count4);       // = 5000
        log.info("count5 = " + count5);       // < 5000
    }

    private static synchronized void add() {
        count4++;
    }
}
