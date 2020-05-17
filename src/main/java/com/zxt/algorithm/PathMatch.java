package com.zxt.algorithm;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 路径匹配
 * 
 * 假如有一个Http Server，可以对不同的路径（path）注册不同的函数（Handler），
 * 
 * 路径的格式为/x/y/z，使用"/"作为分隔符，被分割开的每个组件都是只包含字母的非空字符串；
 * 
 * 路径总是以"/"开头，且不以"/"结尾，也不会出现"/x//y"这样的情况，为了简化问题，我们将处理函数用整数的ID表示。
 * 
 * 对于客户端的HTTP请求，我们需要根据路径匹配最合适的处理函数，匹配规则是：在所有已经注册的路径中，找到包含该路径的最长前缀。
 * 
 * 前缀要求对匹配是完整的，因此"/a/b"是"/a/b/c"的前缀，但不是"/a/bc"的前缀。
 * 
 * 输入部分：第一部分是注册的路径列表，每行两个元素，用空格隔开，分别是路径和ID号；ID号为非0整数，且不会重复；
 * 
 * 第二部分为需要匹配的路径列表，每行一个路径。 两个部分用只包含一个短横线的特殊行分隔。
 * 
 * 输出：对于每个需要匹配的路径，输出其匹配的ID号，每行一个；如果没有找到匹配路径，则输出0
 * 
 * 
 * @author zxt
 *
 */

// 样例输入
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

// 样例输出
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
		// 先存储路径注册信息
		while (sc.hasNext() && !(str = sc.nextLine()).equals("-")) {
			String[] strs = str.split(" ");
			path.put(strs[0], Integer.parseInt(strs[1]));
		}

		while (sc.hasNext()) {
			int maxlength = 0;
			int res = 0;

			String temp = sc.nextLine();
			for (Map.Entry<String, Integer> entry : path.entrySet()) {
				// 将注册表中的每个路径作为正则表达式，来给需要匹配的路径匹配
				Pattern p = Pattern.compile(entry.getKey());
				Matcher m = p.matcher(temp);
				// matches函数是完全匹配，lookingAt是从头开始匹配
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

