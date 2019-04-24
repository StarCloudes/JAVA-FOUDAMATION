package com.qianfeng.service;

import com.qianfeng.domain.User;

public interface UserService {

	//×¢²á
	int register(User user);

	//µÇÂ¼
	User login(String name, String pwd);

}
