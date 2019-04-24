package com.qianfeng.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.qianfeng.dao.UserDao;
import com.qianfeng.domain.User;
import com.qianfeng.util.DBUtil;
//访问数据库
public class UserDaoImpl implements UserDao {

	@Override
	public int register(User user) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		int num = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into user values(?,?,?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setInt(1, 3);
			pStatement.setString(2, user.getName());
			pStatement.setString(3, user.getPassword());
			pStatement.setString(4, user.getEmail());
			//这里因为sql.date的优先级比util.date的低,所以需要进行转化
			pStatement.setDate(5,new Date(user.getBirthday().getTime()));
			pStatement.setInt(6, user.getAge());
			
			num = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(connection, pStatement, null);
		}
		return num;
	}

	
	@Override
	public User login(String name, String pwd) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet set = null;
		User user = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from user where name=? and password=?";
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, name);
			pStatement.setString(2, pwd);
			
			set = pStatement.executeQuery();
			
			if (set.next()) {
				user = new User();
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setPassword(set.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(connection, pStatement, set);
		}
		return user;
	}
}
