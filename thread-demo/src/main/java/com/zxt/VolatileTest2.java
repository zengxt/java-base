package com.zxt;

public class VolatileTest2 {

    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已近给  isRunning 赋值为false了！！");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class RunThread extends Thread {
        volatile private boolean isRunning = true;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }

        public void run() {
            System.out.println("进入run了！！");
            while (isRunning) {

            }
            System.out.println("线程被停止了！！");
        }
    }
}

