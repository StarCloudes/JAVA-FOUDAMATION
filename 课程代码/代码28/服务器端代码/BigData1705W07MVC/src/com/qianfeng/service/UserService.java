package com.qianfeng.service;

import com.qianfeng.domain.User;

public interface UserService {

	//ע��
	int register(User user);

	//��¼
	User login(String name, String pwd);

}
