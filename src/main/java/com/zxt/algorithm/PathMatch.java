package com.zxt.algorithm;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ·��ƥ��
 * 
 * ������һ��Http Server�����ԶԲ�ͬ��·����path��ע�᲻ͬ�ĺ�����Handler����
 * 
 * ·���ĸ�ʽΪ/x/y/z��ʹ��"/"��Ϊ�ָ��������ָ��ÿ���������ֻ������ĸ�ķǿ��ַ�����
 * 
 * ·��������"/"��ͷ���Ҳ���"/"��β��Ҳ�������"/x//y"�����������Ϊ�˼����⣬���ǽ���������������ID��ʾ��
 * 
 * ���ڿͻ��˵�HTTP����������Ҫ����·��ƥ������ʵĴ�������ƥ������ǣ��������Ѿ�ע���·���У��ҵ�������·�����ǰ׺��
 * 
 * ǰ׺Ҫ���ƥ���������ģ����"/a/b"��"/a/b/c"��ǰ׺��������"/a/bc"��ǰ׺��
 * 
 * ���벿�֣���һ������ע���·���б�ÿ������Ԫ�أ��ÿո�������ֱ���·����ID�ţ�ID��Ϊ��0�������Ҳ����ظ���
 * 
 * �ڶ�����Ϊ��Ҫƥ���·���б�ÿ��һ��·���� ����������ֻ����һ���̺��ߵ������зָ���
 * 
 * ���������ÿ����Ҫƥ���·���������ƥ���ID�ţ�ÿ��һ�������û���ҵ�ƥ��·���������0
 * 
 * 
 * @author zxt
 *
 */

// ��������
// /a 1
// /a/b 2
// /a/b/c/d/e/f/g/h/i 3
// /a/bcde 4
// -
// /a
// /a/b
// /a/b/c/d
// /a/b/c/d/e/f/g/h/i
// /a/bcde
// /a/bcdefghi
// /b

// �������
// 1
// 2
// 2
// 3
// 4
// 1
// 0
public class PathMatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> path = new HashMap<String, Integer>();

		String str = null;
		// �ȴ洢·��ע����Ϣ
		while (sc.hasNext() && !(str = sc.nextLine()).equals("-")) {
			String[] strs = str.split(" ");
			path.put(strs[0], Integer.parseInt(strs[1]));
		}

		while (sc.hasNext()) {
			int maxlength = 0;
			int res = 0;

			String temp = sc.nextLine();
			for (Map.Entry<String, Integer> entry : path.entrySet()) {
				// ��ע����е�ÿ��·����Ϊ������ʽ��������Ҫƥ���·��ƥ��
				Pattern p = Pattern.compile(entry.getKey());
				Matcher m = p.matcher(temp);
				// matches��������ȫƥ�䣬lookingAt�Ǵ�ͷ��ʼƥ��
				if (m.matches() || (m.lookingAt() && temp.charAt(m.end()) == '/')) {
					if (maxlength < entry.getKey().length()) {
						maxlength = entry.getKey().length();
						res = entry.getValue();
					}
				}
			}

			System.out.println(res);
		}

		sc.close();
	}
}

