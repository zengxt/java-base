package com.zxt.synch;

/**
 * ʹ��synchronized������ʵ�ֶ��߳�ͬ��
 */
public class TicketThread {
    public static void main(String[] args) {
        // ����һ��������Ʊ   ��������(�����̲߳���)
        TicketWindow tw1 = new TicketWindow();

        new Thread(tw1).start();
        new Thread(tw1).start();
        new Thread(tw1).start();
    }
}

// ��Ʊ������
class TicketWindow implements Runnable {
    // һ����ǧ��Ʊ
    private static int nums = 2000;

    public void run() {
        while (true) {
            try {
                // ��Ʊ�ٶ�1���һ��
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // ������뱣֤�����ԭ���� ��ȷ��nums�Ļ������
            // ͬ�������  ������ʹ��ͬһ��������м�����
            synchronized (this) {
                // �ж��Ƿ���Ʊ
                if (nums > 0) {
                    // ��ʾ��Ʊ��Ϣ
                    System.out.println(Thread.currentThread().getName()
                            + " ���۳��� " + nums + "��Ʊ");
                    nums--;
                } else {
                    break;
                }
            }
        }
    }
}