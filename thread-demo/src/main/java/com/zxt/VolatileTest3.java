package com.zxt;

public class VolatileTest3 {

    public static void main(String[] args) {
        MyThread[] myThreadArray = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreadArray[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++) {
            myThreadArray[i].start();
        }
    }

    /**
     * @Description: 注意一定要添加static关键字，这样synchronized 与 static锁的内容就是MyThread.class类了，也就达到了同步的效果
     * @author： zxt
     * @time: 2018年4月15日 下午4:49:12
     */
    static class MyThread extends Thread {
        volatile public static int count;

        synchronized private static void addCount() {
            for (int i = 0; i < 100; i++) {
                count++;
            }
            System.out.println("count = " + count);
        }

        public void run() {
            addCount();
        }
    }

    /**
     static class MyThread extends Thread {
     volatile public static int count;

     private static void addCount() {
     for (int i = 0; i < 100; i++) {
     count++;
     }
     System.out.println("count = " + count);
     }

     public void run() {
     addCount();
     }
     }
     */
}
