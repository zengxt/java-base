package com.zxt.showimage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFrame extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 300;
	private static final int HEIGHT = 350;
	private ImageIcon image;
	private JLabel label;
	private int maxrange = 20;

	public static void main(String[] args) {
		ImageFrame frame = new ImageFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public ImageFrame() {
		setTitle("ImageThread");
		setSize(WIDTH, HEIGHT);

		setLocationByPlatform(true);

		image = new ImageIcon("./image/1.jpg");
		label = new JLabel(image);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(label);

		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		try {
			while (true) {
				int i = (int) (maxrange * Math.random());
				image = new ImageIcon("./image/" + i + ".jpg");
				label.setIcon(image);
				add(label);
				Thread.sleep(500);
			}
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}