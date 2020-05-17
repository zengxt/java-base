package com.zxt.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentityMatch {

	public static void main(String[] args) {
		// �����Ƿ�Ϊ�Ϸ������֤����
		String[] id_cards = { "130681198712092019", "13068119871209201x", "13068119871209201", "123456789012345",
				"12345678901234x", "1234567890123" };

		// �����Ƿ�Ϊ�Ϸ����֤��������ʽ
		Pattern pattern = Pattern.compile("(\\d{17}[0-9a-zA-Z]|\\d{14}[0-9a-zA-Z])");

		// ������ȡ�������ַ�����������ʽ
		Pattern pattern1 = Pattern.compile("\\d{6}(\\d{8}).*");
		// ���ڽ������ַ����ֽ�Ϊ�����յ�������ʽ
		Pattern pattern2 = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");

		Matcher matcher = pattern.matcher("");
		for (int i = 0; i < id_cards.length; i++) {
			matcher.reset(id_cards[i]);
			System.out.println(id_cards[i] + " is id cards��" + matcher.matches());

			// �������һ���Ϸ������֤�ţ���ȡ��������������
			if (matcher.matches()) {
				Matcher matcher1 = pattern1.matcher(id_cards[i]);
				matcher1.lookingAt();
				String birthday = matcher1.group(1);

				Matcher matcher2 = pattern2.matcher(birthday);
				if (matcher2.find()) {
					System.out.println("����Ӧ�ĳ���������Ϊ��" + matcher2.group(1) + "��" + matcher2.group(2) + "��"
							+ matcher2.group(3) + "��");
				}

			}

			System.out.println();
		}
	}
}