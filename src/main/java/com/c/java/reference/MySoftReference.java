package com.c.java.reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/18 09:48
 * @description 软引用 当堆中内存不够时，JVM会回收软引用指向的堆内存
 **/
public class MySoftReference {
    public static void main(String[] args) {
        int _1M = 1024 * 1024;

        /*
         *  栈中的变量softReference --强引用,指向了--> 堆中的SoftReference对象 --软引用,指向了--> 堆中的byte[10M]
         */
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[10 * _1M]);
        System.out.println(softReference.get());
        System.gc();  // 主动回收，不会回收掉软引用指向的堆内存
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(softReference.get());
        byte[] chars1 = new byte[15 * _1M];
        System.out.println(softReference.get());
    }
}
