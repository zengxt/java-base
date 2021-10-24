package com.zxt.thread.base;

import java.util.Random;

/**
 * �����̵߳ĵڶ��ַ������̳�Thread�ࣨThread�౾��Ҳ��ʵ����Runnable�ӿڣ�
 */
public class Demo02_ExtendsThread extends Thread {
    public static void main(String[] args) {
        Demo02_ExtendsThread t1 = new Demo02_ExtendsThread("����");
        Demo02_ExtendsThread t2 = new Demo02_ExtendsThread("����");

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
