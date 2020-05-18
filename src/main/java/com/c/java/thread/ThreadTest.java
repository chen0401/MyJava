package com.c.java.thread;

import java.util.concurrent.*;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/16 15:25
 * @description
 **/
public class ThreadTest {
    public static void main(String[] args) {
        // 实现Runable接口
        new Thread(new Task()).start();
        // 继承Thread类
        new Task2().start();
        // 线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        executor.execute(new Task());
        executor.shutdown();
        // lambda
        new Thread(() -> {
            System.out.println("thread : " + Thread.currentThread().getId());
        }).start();
        // 实现Callable接口
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
    }

    public static void creatThreadByPool() {

    }
}

/**
 * 实现Runable接口
 */
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("thread : " + Thread.currentThread().getId());
    }
}

/**
 * 继承Thread
 */
class Task2 extends Thread {
    @Override
    public void run() {
        System.out.println("thread : " + Thread.currentThread().getId());
    }
}
/**
 * 通过线程池
 */

