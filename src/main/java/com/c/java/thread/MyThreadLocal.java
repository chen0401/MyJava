package com.c.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/18 15:59
 * @description
 **/
public class MyThreadLocal {
    ThreadLocal threadLocal = new ThreadLocal();

    class Task implements Runnable {
        @Override
        public void run() {
            try {
                // sleep N 秒钟之后获取threadlocalmap中的object
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.set(new Object());
            System.out.println(threadLocal.get());
        }
    }

    public Task getTask() {
        return new Task();
    }

    public static void main(String[] args) {
        MyThreadLocal myThreadLocal = new MyThreadLocal();
        // 开启一个新线程
        new Thread(myThreadLocal.getTask()).start();
        // 在主线程中，在threadlocalmap中存一个object
        myThreadLocal.threadLocal.set(new Object());
        // 在主线程中获取这个object
        System.out.println(myThreadLocal.threadLocal.get());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThreadLocal.threadLocal.get());
    }
}
