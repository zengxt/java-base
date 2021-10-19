package com.zxt;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedTest {

    public static void main(String[] args) {

        try {
            WriteData writeData = new WriteData();
            final ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            // 将管道关联上
            outputStream.connect(inputStream);

            // 向管道写数据线程
            new Thread(new Runnable() {

                @Override
                public void run() {
                    writeData.writeMethod(outputStream);
                }
            }).start();

            Thread.sleep(200);

            // 从管道中读数据线程
            new Thread(new Runnable() {

                @Override
                public void run() {
                    readData.readMethod(inputStream);
                }
            }).start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class WriteData {

    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write：");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadData {

    public void readMethod(PipedInputStream in) {
        try {
            System.out.println("read：");
            byte[] byteArray = new byte[20];
            int readLength = in.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = in.read(byteArray);
            }
            System.out.println();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}