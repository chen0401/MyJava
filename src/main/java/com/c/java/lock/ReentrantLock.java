package com.c.java.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/16 20:59
 * @description
 **/
public class ReentrantLock {
    Lock lock = new java.util.concurrent.locks.ReentrantLock();
}
