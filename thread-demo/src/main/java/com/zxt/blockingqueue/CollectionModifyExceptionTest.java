package com.zxt.blockingqueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionModifyExceptionTest {
	
	public static void main(String[] args) {
		// ArraysList的迭代器，在迭代的过程中如果修改了List的结构，则会异常
		// Collection<User> users = new ArrayList<User>();
		
		Collection<User> users = new CopyOnWriteArrayList<User>();

		users.add(new User("张三", 28));
		users.add(new User("李四", 25));
		users.add(new User("王五", 31));
		
		Iterator<User> itrUsers = users.iterator();
		while (itrUsers.hasNext()) {
			User user = itrUsers.next();
			if ("张三".equals(user.getName())) {
				users.remove(user);
				
			} else {
				System.out.println(user);
			}
		}
	}
}
