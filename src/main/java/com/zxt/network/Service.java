package com.zxt.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @Description: 简单的Client/Server程序设计（服务端）
 *
 * @author： zxt
 *
 * @time: 2018年5月29日 上午11:29:24
 *
 */
public class Service {
	
	public static void main(String[] args) {
		try {
			
			ServerSocket server = null;
			try {
				// 创建一个 ServerSocket 在端口4700监听客户请求
				server = new ServerSocket(4700);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("server-------------------------------");
			
			
			Socket socket = null;
			try {
				// 使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
				socket = server.accept();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			// 由Socket对象得到输入流，并构造相应的BufferedReader对象
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 由Socket对象得到输出流，并构造相应的PrintWriter对象
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			
			// 由系统标准输入设备构造BufferedReader对象
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			// 在标准输出上打印从客户端读入的字符串
			System.out.println("Client: " + is.readLine());
			
			String line = sin.readLine();
			while(!line.equals("bye")) {
				// 向客户端输出
				os.println(line);
				// 刷新输出流，使Client马上收到该字符串
				os.flush();
				
				// 输出从客户端读取到的数据
				System.out.println("Client: " + is.readLine() + "\n");
				
				line = sin.readLine();
			}
			
			
			// 关闭资源
			os.close();
			is.close();
			socket.close();
			server.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
