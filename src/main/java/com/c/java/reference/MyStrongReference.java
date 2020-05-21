package com.c.java.reference;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/18 09:44
 * @description 强引用 一般普通引用都是强引用，当没有引用指向Object实例时，才会被GC
 **/
public class MyStrongReference {
    public static void main(String[] args) {
        Object object = new Object();
    }
}
