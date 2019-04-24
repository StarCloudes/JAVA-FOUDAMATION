package com.classroom28.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.classroom28.javabean.User;
import com.classroom28.utils.DBUtil;

public class ServerDemo {
	public static User findUser(String username, String password) {	
		Connection connection = null;
		Statement statement = null;
		ResultSet set = null;
		User user = null;
		
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			String sql = "select * from user where name = '"+ username + "' and password = '" + password +"'";
			set = statement.executeQuery(sql);
			if(set.next()) {
				user = new User();
				user.setId(set.getString("id"));
				user.setName(set.getString("name"));
				user.setPassword(set.getString("password"));
				user.setAge(set.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(connection, statement, set);
		}
		
		return user;		
	}
	
	//利用改进小车解决sql注入的问题
	public static User findUser1(String username, String password) {	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		User user = null;
		
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from user where name =？and password =？";
			//绑定sql
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
	
			set = statement.executeQuery();
			if(set.next()) {
				user = new User();
				user.setId(set.getString("id"));
				user.setName(set.getString("name"));
				user.setPassword(set.getString("password"));
				user.setAge(set.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(connection, statement, set);
		}
		
		return user;		
	}
}
