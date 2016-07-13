package cn.edu.henu.rjxy.sumproject.service;

import cn.edu.henu.rjxy.sumproject.bean.User;
import cn.edu.henu.rjxy.sumproject.bean.UserNameRegistedException;
import cn.edu.henu.rjxy.sumproject.dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	
	public void regist(User user) throws UserNameRegistedException {
		userDao.registUser(user);
	}

}
