package com.zxt;

public class SynchronizedTest {

    public static void main(String[] args) {
        final Service service = new Service();

        // �߳�a
        new Thread(new Runnable() {

            @Override
            public void run() {
                service.runMethod();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // �߳�b
        new Thread(new Runnable() {

            @Override
            public void run() {
                service.stopMethod();
            }
        }).start();

        System.out.println("�Ѿ�������ֹͣ�������ˣ�");
    }
}

class Service {
    // �������
    private boolean isContinueRun = true;

    public void runMethod() {
        String anyString = new String();
        while (isContinueRun) {
            synchronized (anyString) {

            }
        }
        System.out.println("�߳�ֹͣ����");
    }

    public void stopMethod() {
        isContinueRun = false;
    }
}
