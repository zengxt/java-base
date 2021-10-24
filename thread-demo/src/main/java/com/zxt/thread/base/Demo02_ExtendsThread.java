package com.zxt.thread.base;

import java.util.Random;

/**
 * 创建线程的第二种方法，继承Thread类（Thread类本质也是实现了Runnable接口）
 */
public class Demo02_ExtendsThread extends Thread {
    public static void main(String[] args) {
        Demo02_ExtendsThread t1 = new Demo02_ExtendsThread("张三");
        Demo02_ExtendsThread t2 = new Demo02_ExtendsThread("李四");

        t1.start();
        t2.start();
    }

    public Demo02_ExtendsThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(new Random().nextInt(10) * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
