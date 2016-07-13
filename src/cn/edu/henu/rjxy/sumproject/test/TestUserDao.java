package cn.edu.henu.rjxy.sumproject.test;

import java.util.UUID;

import org.junit.Test;

import cn.edu.henu.rjxy.sumproject.bean.User;
import cn.edu.henu.rjxy.sumproject.bean.UserNameRegistedException;
import cn.edu.henu.rjxy.sumproject.dao.UserDao;

public class TestUserDao {

	@Test
	public void testRegistUser() throws UserNameRegistedException {
		User user  = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUsername("ww");
		user.setPassword("123456");
		UserDao userDao = new UserDao();
		userDao.registUser(user);
	}
}
