package com.zxt;

public class Main extends Thread {


    public static void main(String[] args) {
        Main myThread = new Main();
        myThread.setName("A");
        myThread.start();
    }

    public Main() {
        System.out.println("------" + "���캯����ʼ" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("------" + "���캯������" + "------");
    }

    @Override
    public void run() {
        System.out.println("------" + "run()��ʼ" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("Thread.currentThread() == this : " + (Thread.currentThread() == this));
        System.out.println("------" + "run()����" + "------");
    }
}
