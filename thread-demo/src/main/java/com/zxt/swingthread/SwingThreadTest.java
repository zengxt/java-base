package com.zxt.swingthread;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

/**
 * This program demonstrates that a thread that runs in parallel with the event
 * dispatch thread can cause errors in Swing components.
 * 
 * @version 1.23 2007-05-17
 * @author Cay Horstmann
 */
public class SwingThreadTest {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SwingThreadFrame frame = new SwingThreadFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * This frame has two buttons to fill a combo box from a separate thread. The
 * "Good" button uses the event queue, the "Bad" button modifies the combo box
 * directly.
 */
class SwingThreadFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public SwingThreadFrame() {
		setTitle("SwingThreadTest");

		final JComboBox<Integer> combo = new JComboBox<Integer>();
		combo.insertItemAt(Integer.MAX_VALUE, 0);
		combo.setPrototypeDisplayValue(combo.getItemAt(0));
		combo.setSelectedIndex(0);

		JPanel panel = new JPanel();

		JButton goodButton = new JButton("Good");
		goodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(new GoodWorkerRunnable(combo)).start();
			}
		});
		panel.add(goodButton);
		
		JButton badButton = new JButton("Bad");
		badButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(new BadWorkerRunnable(combo)).start();
			}
		});
		panel.add(badButton);

		panel.add(combo);
		add(panel);
		pack();
	}
}

/**
 * This runnable modifies a combo box by randomly adding and removing numbers.
 * This can result in errors because the combo box methods are not synchronized
 * and both the worker thread and the event dispatch thread access the combo
 * box.
 */
class BadWorkerRunnable implements Runnable {
	private JComboBox<Integer> combo;
	private Random generator;
	
	public BadWorkerRunnable(JComboBox<Integer> aCombo) {
		combo = aCombo;
		generator = new Random();
	}

	public void run() {
		try {
			while (true) {
				int i = Math.abs(generator.nextInt());
				if (i % 2 == 0)
					combo.insertItemAt(i, 0);
				else if (combo.getItemCount() > 0)
					combo.removeItemAt(i % combo.getItemCount());
				Thread.sleep(1);
			}
			
		} catch (InterruptedException e) {
			
		}
	}
}

/**
 * This runnable modifies a combo box by randomly adding and removing numbers.
 * In order to ensure that the combo box is not corrupted, the editing
 * operations are forwarded to the event dispatch thread.
 */
class GoodWorkerRunnable implements Runnable {
	private JComboBox<Integer> combo;
	private Random generator;
	
	public GoodWorkerRunnable(JComboBox<Integer> aCombo) {
		combo = aCombo;
		generator = new Random();
	}

	public void run() {
		try {
			while (true) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						int i = Math.abs(generator.nextInt());
						if (i % 2 == 0)
							combo.insertItemAt(i, 0);
						else if (combo.getItemCount() > 0)
							combo.removeItemAt(i % combo.getItemCount());
					}
				});
				Thread.sleep(1);
			}
			
		} catch (InterruptedException e) {
			
		}
	}
}