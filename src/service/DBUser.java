/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.List;

import bean.User;

/**
 * @author Administrator
 * @date 2019年3月13日 下午4:45:41
 * @description
 */
public class DBUser {
	private static List<User> userList = new ArrayList<>();
	static {
		userList.add(new User("aaa", "123"));
		userList.add(new User("aaa", "123"));
		userList.add(new User("aaa", "123"));
		userList.add(new User("aaa", "123"));
		userList.add(new User("aaa", "123"));
	}

	public static User find(String username, String pwd) {
		for (User user : userList) {
			if (user.getName().equals(username) && user.getPwd().equals(pwd)) {
				return user;
			}
		}
		return null;
	}

}
