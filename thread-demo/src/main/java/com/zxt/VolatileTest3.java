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
     * @Description: ע��һ��Ҫ���static�ؼ��֣�����synchronized �� static�������ݾ���MyThread.class���ˣ�Ҳ�ʹﵽ��ͬ����Ч��
     * @author�� zxt
     * @time: 2018��4��15�� ����4:49:12
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
