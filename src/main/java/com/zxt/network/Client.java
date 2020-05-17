package com.zxt.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @Description: �򵥵�Client/Server������ƣ��ͻ��ˣ�
 *
 * @author�� zxt
 *
 * @time: 2018��5��29�� ����11:29:24
 *
 */
public class Client {

	public static void main(String[] args) {
		
		try {
			// �򱾻���4700�˿ڷ����ͻ�����
			Socket socket = new Socket("127.0.0.1", 4700);
			
			// ��Socket����õ�����������������Ӧ��BufferedReader����
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// ��Socket����õ����������������Ӧ��PrintWriter����
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			
			// ��ϵͳ��׼�����豸����BufferedReader����
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Client-------------------------------");
			
			
			String line = sin.readLine();
			while(!line.equals("bye")) {
				// ���������
				os.println(line);
				// ˢ���������ʹServer�����յ����ַ���
				os.flush();
				
				// ����ӷ���˶�ȡ��������
				System.out.println("Server: " + is.readLine() + "\n");
				
				line = sin.readLine();
			}
			
			
			// �ر���Դ
			os.close();
			is.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
