package com.zxt.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d+");

		// matches()�������ַ�������ƥ��
		// ����false����Ϊbb���ܱ�\d+ƥ�䣬���������ַ���ƥ��δ�ɹ���
		Matcher m = p.matcher("22bb23");
		System.out.println(m.matches());
		m = p.matcher("2223");
		// ����true����Ϊ\d+ƥ�䵽�������ַ���
		System.out.println(m.matches());

		// lookingAt()���ַ���ǰ׺����ƥ��
		m = p.matcher("22bb23");
		// ����true,��Ϊ\d+ƥ�䵽��ǰ���22
		System.out.println(m.lookingAt());
		m = p.matcher("aa2223");
		// ����false,��Ϊ\d+����ƥ��ǰ���aa
		System.out.println(m.lookingAt());

		// find()���ַ�������ƥ��,ƥ�䵽���ַ����������κ�λ�á�
		m = p.matcher("22bb23");
		System.out.println(m.find()); // true
		m = p.matcher("aa2223");
		System.out.println(m.find()); // true
		m = p.matcher("aabb");
		System.out.println(m.find()); // false
		// ��ƥ����ƥ��ʧ��ʱ��ʹ�÷���ƥ����״̬�ķ������������磺m.start();

		m = p.matcher("aa2223bb");
		System.out.println(m.find()); // true

		System.out.println(m.start()); // 2
		System.out.println(m.end()); // 6
		System.out.println(m.group()); // 2223

		p = Pattern.compile("([a-z]+)(\\d+)");
		m = p.matcher("aaa2223bb");
		// ƥ��aaa2223
		m.find();
		// ����2,��Ϊ��2��
		System.out.println(m.groupCount());
		// ����0, ���ص�һ��ƥ�䵽�����ַ������ַ����е�������
		System.out.println(m.start(1));
		// ����3
		System.out.println(m.start(2));
		// ����3 ���ص�һ��ƥ�䵽�����ַ��������һ���ַ����ַ����е�����λ��.
		System.out.println(m.end(1));
		// ����2223,���صڶ���ƥ�䵽�����ַ���
		System.out.println(m.group(2));
	}
}
