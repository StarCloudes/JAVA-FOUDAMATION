package com.qianfeng.service.impl;

import com.qianfeng.dao.UserDao;
import com.qianfeng.dao.impl.UserDaoImpl;
import com.qianfeng.domain.User;
import com.qianfeng.service.UserService;
//´¦ÀíÂß¼­
public class UserServiceImpl implements UserService {
	UserDao uDao = new UserDaoImpl();
	@Override
	public int register(User user) {
		int num = uDao.register(user);
		return num;
	}
	
	@Override
	public User login(String name, String pwd) {
		return uDao.login(name,pwd);
		
	}
}
