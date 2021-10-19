package com.zxt.blockingqueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionModifyExceptionTest {
	
	public static void main(String[] args) {
		// ArraysList�ĵ��������ڵ����Ĺ���������޸���List�Ľṹ������쳣
		// Collection<User> users = new ArrayList<User>();
		
		Collection<User> users = new CopyOnWriteArrayList<User>();

		users.add(new User("����", 28));
		users.add(new User("����", 25));
		users.add(new User("����", 31));
		
		Iterator<User> itrUsers = users.iterator();
		while (itrUsers.hasNext()) {
			User user = itrUsers.next();
			if ("����".equals(user.getName())) {
				users.remove(user);
				
			} else {
				System.out.println(user);
			}
		}
	}
}
