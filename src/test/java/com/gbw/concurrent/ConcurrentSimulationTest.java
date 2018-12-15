package com.gbw.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class ConcurrentSimulationTest {
    private int count = 0;

    @Test
    public void myTest() throws InterruptedException {
        final int CLIENT_TOTAL = 5000;
        final int THREAD_TOTAL = 200;
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
        final CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL);
        for (int i = 0; i < CLIENT_TOTAL ; i++) {
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception!", e);
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count = " + count);
        // count < 5000
    }
}
