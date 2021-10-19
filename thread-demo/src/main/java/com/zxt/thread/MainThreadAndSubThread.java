package com.zxt.thread;

/*
 * ���߳�ѭ��10�Σ��������߳�ѭ��5�������ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��5�����ѭ��50��
 */
public class MainThreadAndSubThread {

    public static void main(String[] args) {
        new MainThreadAndSubThread().init();
    }

    public void init() {

        final Business business = new Business();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.SubThread(i);
                }
            }

        }
        ).start();

        for (int i = 0; i < 50; i++) {
            business.MainThread(i);
        }
    }

    private class Business {
        // �����൱�ڶ����˿��Ƹ�˭ִ�е�һ���źŵ�
        boolean bShouldSub = true;

        public synchronized void MainThread(int i) {
            if (bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 0; j < 5; j++) {
                System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
            }
            bShouldSub = true;
            this.notify();
        }

        public synchronized void SubThread(int i) {
            if (!bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
            }
            bShouldSub = false;
            this.notify();
        }
    }
}