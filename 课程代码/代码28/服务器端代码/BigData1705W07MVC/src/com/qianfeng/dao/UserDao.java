package com.qianfeng.dao;

import com.qianfeng.domain.User;

public interface UserDao {

	int register(User user);

	User login(String name, String pwd);

}
