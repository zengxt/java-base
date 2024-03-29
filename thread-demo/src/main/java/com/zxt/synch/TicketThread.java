package com.zxt.synch;

/**
 * 使用synchronized锁，来实现多线程同步
 */
public class TicketThread {
    public static void main(String[] args) {
        // 创建一个窗口售票   启动三次(三个线程操作)
        TicketWindow tw1 = new TicketWindow();

        new Thread(tw1).start();
        new Thread(tw1).start();
        new Thread(tw1).start();
    }
}

// 售票窗口类
class TicketWindow implements Runnable {
    // 一共两千张票
    private static int nums = 2000;

    public void run() {
        while (true) {
            try {
                // 出票速度1秒出一张
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // 这里必须保证代码的原子性 以确保nums的互斥访问
            // 同步代码块  （必须使用同一个对象进行加锁）
            synchronized (this) {
                // 判断是否还有票
                if (nums > 0) {
                    // 显示售票信息
                    System.out.println(Thread.currentThread().getName()
                            + " 在售出第 " + nums + "车票");
                    nums--;
                } else {
                    break;
                }
            }
        }
    }
}