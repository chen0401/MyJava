package com.c.java.reference;

import java.lang.ref.WeakReference;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/18 13:10
 * @description 弱引用 JVM一旦回收，就会回收掉弱引用指向的堆内存
 **/
public class MyWeakReference {
    public static void main(String[] args) {
        WeakReference<Object> weakReference = new WeakReference<>(new Object());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
