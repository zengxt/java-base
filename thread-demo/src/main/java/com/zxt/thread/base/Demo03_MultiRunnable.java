package com.zxt.thread.base;

/**
 * ���߳̾���
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

// ��ӡ
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
            System.out.println("����һ���̣߳��������" + times + "�� Hello World!");
            if (times == age) {
                break;
            }
        }
    }
}

// ����
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
            System.out.println("��ǰ����ǣ�" + res);
            if (times == age) {
                System.out.println("������ǣ�" + res);
                break;
            }
        }
    }
}