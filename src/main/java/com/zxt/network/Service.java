package com.zxt.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @Description: �򵥵�Client/Server������ƣ�����ˣ�
 *
 * @author�� zxt
 *
 * @time: 2018��5��29�� ����11:29:24
 *
 */
public class Service {
	
	public static void main(String[] args) {
		try {
			
			ServerSocket server = null;
			try {
				// ����һ�� ServerSocket �ڶ˿�4700�����ͻ�����
				server = new ServerSocket(4700);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("server-------------------------------");
			
			
			Socket socket = null;
			try {
				// ʹ��accept()�����ȴ��ͻ������пͻ������������һ��Socket���󣬲�����ִ��
				socket = server.accept();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			// ��Socket����õ�����������������Ӧ��BufferedReader����
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// ��Socket����õ����������������Ӧ��PrintWriter����
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			
			// ��ϵͳ��׼�����豸����BufferedReader����
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			// �ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
			System.out.println("Client: " + is.readLine());
			
			String line = sin.readLine();
			while(!line.equals("bye")) {
				// ��ͻ������
				os.println(line);
				// ˢ���������ʹClient�����յ����ַ���
				os.flush();
				
				// ����ӿͻ��˶�ȡ��������
				System.out.println("Client: " + is.readLine() + "\n");
				
				line = sin.readLine();
			}
			
			
			// �ر���Դ
			os.close();
			is.close();
			socket.close();
			server.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
