package com.c.java.objectheader;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author cjianping@ruijie.com.cn
 * @date 2020/5/15 14:43
 * @description
 **/
public class Markword {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        int hashCode = person.hashCode();
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        //while (true) {
        synchronized (person) {
            System.out.println(ClassLayout.parseInstance(person).toPrintable());
            //  }
        }

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                synchronized (person) {
                    System.out.println(ClassLayout.parseInstance(person).toPrintable());
                }
            }).start();
        }
    }

}
