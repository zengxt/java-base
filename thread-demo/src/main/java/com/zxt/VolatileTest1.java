package com.zxt;

public class VolatileTest1 {

    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("�ѽ���  isRunning ��ֵΪfalse�ˣ���");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class RunThread extends Thread {
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        System.out.println("����run�ˣ���");
        while (isRunning) {

        }
        System.out.println("�̱߳�ֹͣ�ˣ���");
    }
}