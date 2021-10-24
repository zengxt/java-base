package com.zxt.thread.base;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 开启线程下载图片
 */
public class Demo04_DownloadThread implements Runnable {
    private String url;
    private String name;

    Demo04_DownloadThread(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("图片下载完成！" + name);
    }

    public static void main(String[] args) {
        Demo04_DownloadThread downloadThread1 = new Demo04_DownloadThread("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201305%2F29%2F101838y2tkuxpfopkwzpvg.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637599201&t=9b574b2fe59dbf7a3aaafc84fb14b4d7", "1.jpg");
        Demo04_DownloadThread downloadThread2 = new Demo04_DownloadThread("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Ff%2F58cf4062a1656.jpg%3Fdown&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637599201&t=d0c78da5ea10733f1f072840aea1d251", "2.jpg");
        Demo04_DownloadThread downloadThread3 = new Demo04_DownloadThread("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.33lc.com%2Farticle%2FUploadPic%2F2012-7%2F201272614275728076.jpg&refer=http%3A%2F%2Fwww.33lc.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637599201&t=f0d3a957116887f31058e98d5071831e", "3.jpg");
        new Thread(downloadThread1).start();
        new Thread(downloadThread2).start();
        new Thread(downloadThread3).start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载图片失败，IO异常！！！");
        }
    }
}