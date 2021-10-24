package com.zxt.thread.base;

public class Demo05_ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程运行。。。");
        });

        // NEW
        System.out.println(thread.getState());

        // RUNNABLE
        thread.start();
        System.out.println(thread.getState());

        while (thread.getState() != Thread.State.TERMINATED) {
            // sleep 的时候线程处于阻塞状态：TIMED_WAITING
            System.out.println(thread.getState());
        }

        // TERMINATED
        System.out.println(thread.getState());
    }
}
