package com.zxt.base;

/**
 * Java��ȡ��Դʱ�������õ�Class.getResource��ClassLoader.getResource
 * 
 * ע���ȡ��Դʱ����ȡ���Ǳ���֮���class�ļ���Դ���������ȡjavaԴ����
 * 
 * @author zxt
 *
 */

public class GetResourceTest {

	public static void main(String[] args) {
		// Class.getResource(String path)
		// path����'/'��ͷʱ��Ĭ���ǴӴ������ڵİ���ȡ��Դ��
		// path ��'/'��ͷʱ�����Ǵ�ClassPath���»�ȡ��(�൱��binĿ¼(Eclipse������))
		// ��ǰ��(class)���ڵİ�Ŀ¼ (ָ����Դ�������Ի�ȡ�ð������������Դ)
		System.out.println(GetResourceTest.class.getResource(""));
		// class path��Ŀ¼ (ָ����Դ�������Ի�ȡ��Ŀ¼�������Դ)
		System.out.println(GetResourceTest.class.getResource("/"));
		
		// Class.getResource��Class.getResourceAsStream��ʹ��ʱ��·��ѡ������һ���ġ�
		// getResourceAsStream()���������൱������getResource()ȡ��File�ļ�����new InputStream(file)һ���Ľ�� 
		
		
		// Class.getClassLoader().getResource(String path)
		// path�Ǵ�ClassPath���»�ȡ
		System.out.println(GetResourceTest.class.getClassLoader().getResource(""));
		System.out.println(GetResourceTest.class.getClassLoader().getResource("").getPath());
		// GetResourceTest.class.getResource("/") == GetResourceTest.class.getClassLoader().getResource("")
		// path������'/'��ͷ
		System.out.println(GetResourceTest.class.getClassLoader().getResource("/"));
	}

}
