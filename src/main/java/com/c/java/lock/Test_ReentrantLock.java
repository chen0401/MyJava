package com.c.java.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/16 20:59
 * @description 可重入锁
 **/
public class Test_ReentrantLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        executor.execute(new Task(lock));
        executor.execute(new Task(lock));
    }

    static class Task implements Runnable {
        Lock lock;

        public Task(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getId() + " lock start.");
                lock.lock();
                System.out.println("Thread " + Thread.currentThread().getId() + " lock success.");
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread " + Thread.currentThread().getId() + " unlock start.");
                lock.unlock();
                System.out.println("Thread " + Thread.currentThread().getId() + " unlock success.");
            }
        }
    }

}
