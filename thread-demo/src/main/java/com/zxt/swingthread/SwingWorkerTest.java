package com.zxt.swingthread;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

import javax.swing.*;

/**
 * This program demonstrates a worker thread that runs a potentially
 * time-consuming task.
 * 
 * @version 1.1 2007-05-18
 * @author Cay Horstmann
 */
public class SwingWorkerTest {
	
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SwingWorkerFrame frame = new SwingWorkerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * This frame has a text area to show the contents of a text file, a menu to
 * open a file and cancel the opening process, and a status line to show the
 * file loading progress.
 */
class SwingWorkerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JFileChooser chooser;
	private JTextArea textArea;
	private JLabel statusLine;
	private JMenuItem openItem;
	private JMenuItem cancelItem;
	private SwingWorker<StringBuilder, ProgressData> textReader;

	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	
	public SwingWorkerFrame() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));

		textArea = new JTextArea();
		add(new JScrollPane(textArea));
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		statusLine = new JLabel(" ");
		add(statusLine, BorderLayout.SOUTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// show file chooser dialog
				int result = chooser.showOpenDialog(null);

				// if file selected, set it as icon of the label
				if (result == JFileChooser.APPROVE_OPTION) {
					textArea.setText("");
					openItem.setEnabled(false);
					textReader = new TextReader(chooser.getSelectedFile());
					textReader.execute();
					cancelItem.setEnabled(true);
				}
			}
		});

		cancelItem = new JMenuItem("Cancel");
		menu.add(cancelItem);
		cancelItem.setEnabled(false);
		cancelItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textReader.cancel(true);
			}
		});
	}

	private class ProgressData {
		public int number;
		public String line;
	}

	private class TextReader extends SwingWorker<StringBuilder, ProgressData> {
		private File file;
		private StringBuilder text = new StringBuilder();
		private Scanner in;
		
		public TextReader(File file) {
			this.file = file;
		}

		// the following method executes in the worker thread; it doesn't touch
		// Swing components
		@Override
		public StringBuilder doInBackground() throws IOException,
				InterruptedException {
			int lineNumber = 0;
			in = new Scanner(new FileInputStream(file));
			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				lineNumber++;
				text.append(line);
				text.append("\n");
				ProgressData data = new ProgressData();
				data.number = lineNumber;
				data.line = line;
				publish(data);
				// to test cancellation; no need to do this in your programs
				Thread.sleep(1); 
			}
			
			return text;
		}

		// the following methods execute in the event dispatch thread
		@Override
		public void process(List<ProgressData> data) {
			if (isCancelled())
				return;
			StringBuilder b = new StringBuilder();
			statusLine.setText("" + data.get(data.size() - 1).number);
			for (ProgressData d : data) {
				b.append(d.line);
				b.append("\n");
			}
			textArea.append(b.toString());
		}

		@Override
		public void done() {
			try {
				StringBuilder result = get();
				textArea.setText(result.toString());
				statusLine.setText("Done");
				
			} catch (InterruptedException ex) {
				
			} catch (CancellationException ex) {
				textArea.setText("");
				statusLine.setText("Cancelled");
				
			} catch (ExecutionException ex) {
				statusLine.setText("" + ex.getCause());
			}

			cancelItem.setEnabled(false);
			openItem.setEnabled(true);
		}
	};
}