package com.zxt.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @Description: 简单的Client/Server程序设计（客户端）
 *
 * @author： zxt
 *
 * @time: 2018年5月29日 上午11:29:24
 *
 */
public class Client {

	public static void main(String[] args) {
		
		try {
			// 向本机的4700端口发出客户请求
			Socket socket = new Socket("127.0.0.1", 4700);
			
			// 由Socket对象得到输入流，并构造相应的BufferedReader对象
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 由Socket对象得到输出流，并构造相应的PrintWriter对象
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			
			// 由系统标准输入设备构造BufferedReader对象
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Client-------------------------------");
			
			
			String line = sin.readLine();
			while(!line.equals("bye")) {
				// 向服务端输出
				os.println(line);
				// 刷新输出流，使Server马上收到该字符串
				os.flush();
				
				// 输出从服务端读取到的数据
				System.out.println("Server: " + is.readLine() + "\n");
				
				line = sin.readLine();
			}
			
			
			// 关闭资源
			os.close();
			is.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
