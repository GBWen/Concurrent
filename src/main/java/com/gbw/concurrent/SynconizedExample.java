package com.gbw.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class SynconizedExample {
    public void test1(Integer j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰方法 也是作用于调用对象
    public synchronized void test2(Integer j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    // 静态 作用于所有对象
    public static synchronized void test3(Integer j) {
        for (int i = 0; i < 10; i++) {
            log.info("test3 {} - {}", j, i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynconizedExample example = new SynconizedExample();
        example.runTest();
    }

    private void runTest() throws InterruptedException {
        SynconizedExample example1 = new SynconizedExample();
        SynconizedExample example2 = new SynconizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> {
//            example1.test1(1);
//        });
//        executorService.execute(() -> {
//            example2.test1(2);
//        });

//        executorService.execute(() -> {
//            example1.test2(1);
//        });
//        executorService.execute(() -> {
//            example2.test2(2);
//        });

        executorService.execute(() -> {
            example1.test3(1);
        });
        executorService.execute(() -> {
            example2.test3(2);
        });
        executorService.shutdown();
    }
}
