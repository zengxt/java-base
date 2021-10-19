package com.zxt;

public class SynchronizedTest {

    public static void main(String[] args) {
        final Service service = new Service();

        // 线程a
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

        // 线程b
        new Thread(new Runnable() {

            @Override
            public void run() {
                service.stopMethod();
            }
        }).start();

        System.out.println("已经发起了停止的命令了！");
    }
}

class Service {
    // 共享变量
    private boolean isContinueRun = true;

    public void runMethod() {
        String anyString = new String();
        while (isContinueRun) {
            synchronized (anyString) {

            }
        }
        System.out.println("线程停止！！");
    }

    public void stopMethod() {
        isContinueRun = false;
    }
}
