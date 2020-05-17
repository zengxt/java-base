package com.zxt.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * һ���򵥵��ʼ���ַƥ�����
 */
public class EmailMatch {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.nextLine();
			
			// ��������EMAIL��ַ�Ƿ��� �Ƿ����Ż�"@"��Ϊ��ʼ�ַ�
			Pattern p = Pattern.compile("^@");
			Matcher m = p.matcher(input);
			if (m.lookingAt()) {
				System.out.println("EMAIL��ַ������'@'��Ϊ��ʼ�ַ�");
			}

			// ����Ƿ���"www."Ϊ��ʼ
			p = Pattern.compile("^www.");
			m = p.matcher(input);
			if (m.lookingAt()) {
				System.out.println("EMAIL��ַ������'www.'��ʼ");
			}

			// ����Ƿ�����Ƿ��ַ�
			p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
			m = p.matcher(input);
			StringBuffer sb = new StringBuffer();
			boolean result = m.find();
			boolean deletedIllegalChars = false;

			while (result) {
				// ����ҵ��˷Ƿ��ַ���ô�����±��
				deletedIllegalChars = true;
				// �����������Ƿ��ַ���ð��˫���ŵȣ���ô�Ͱ�������ȥ���ӵ�SB����
				m.appendReplacement(sb, "");
				result = m.find();
			}

			// �˷��������λ�ÿ�ʼ���������ж�ȡ�ַ�����������ӵ������ַ�����������
			// ������һ�λ��ε��� appendReplacement �����������������ʣ����������С�
			m.appendTail(sb);
			if (deletedIllegalChars) {
				System.out.println("�����EMAIL��ַ�������ð�š����ŵȷǷ��ַ������޸�");
				System.out.println("�����ڵ�����Ϊ: " + input);
				System.out.println("�޸ĺ�Ϸ��ĵ�ַӦ����: " + sb.toString());
			}
		}

		sc.close();
	}
}