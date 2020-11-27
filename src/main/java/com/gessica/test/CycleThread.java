package com.gessica.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CycleThread {
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThread pa = new MyThread("A", c, a);
        MyThread pb = new MyThread("B", a, b);
        MyThread pc = new MyThread("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);// 保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
        Executors.newCachedThreadPool();
    }
}
