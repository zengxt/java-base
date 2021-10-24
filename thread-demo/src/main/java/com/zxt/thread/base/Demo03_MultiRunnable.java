package com.zxt.thread.base;

/**
 * 多线程举例
 */
public class Demo03_MultiRunnable {
    public static void main(String[] args) {
        Pig pig = new Pig(10);
        Bird bird = new Bird(10);

        Thread t1 = new Thread(pig);
        Thread t2 = new Thread(bird);

        t1.start();
        t2.start();
    }
}

class Animal {
    int age;
    int times = 0;

    public Animal(int age) {
        this.age = age;
    }
}

// 打印
class Pig extends Animal implements Runnable {
    public Pig(int age) {
        super(age);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            times++;
            System.out.println("我是一个线程，在输出第" + times + "个 Hello World!");
            if (times == age) {
                break;
            }
        }
    }
}

// 计算
class Bird extends Animal implements Runnable {
    int res = 0;

    public Bird(int age) {
        super(age);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            res += (++times);
            System.out.println("当前结果是：" + res);
            if (times == age) {
                System.out.println("最后结果是：" + res);
                break;
            }
        }
    }
}