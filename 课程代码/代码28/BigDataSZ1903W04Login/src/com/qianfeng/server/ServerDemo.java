package com.qianfeng.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qianfeng.javabean.User;
import com.qianfeng.utils.DBUtil;

public class ServerDemo {
	/*
	 * 验证客户端的账号,密码
	 * 错误名称:sql注入
	 * 账号:chenchen
	 * 密码:' or 1='1
	 * sql语句:select * from user where name='chenchen' and password='' or 1='1'
	 * 这是,where后面变成了恒真,所以跟没有写where没有区别,会将所有的结果查出来
	 */
	public static User findUser(String username, String pwd) {
		//1.获取驱动
		//2.获取连接
		Connection connection = null;
		Statement statement = null;
		ResultSet set = null;
		User user = null;
		try {
			connection = DBUtil.getConnection();
			//3.创建小车绑定sql语句
			statement = connection.createStatement();
			//编写sql语句,根据姓名和密码查询记录
			String sql = "select * from user where name='"+username+"' and password='"+pwd+"'";
		    set = statement.executeQuery(sql);
			//4.卸货
		    if (set.next()) {
				user = new User();
				user.setId(set.getString("id"));
				user.setName(set.getString("name"));
				user.setAge(set.getInt("age"));
				user.setPassword(set.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5.关闭资源
			DBUtil.closeAll(connection, statement, set);
		}

		return user;
	}
	
	
	//利用改进的小车解决sql 注入问题
	public static User findUser1(String username, String pwd) {
		//1.获取驱动
		//2.获取连接
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		User user = null;
		try {
			connection = DBUtil.getConnection();
			//编写sql语句,根据姓名和密码查询记录
			String sql = "select * from user where name=? and password=?";//?是占位符
			//3.创建小车绑定sql语句
			statement = connection.prepareStatement(sql);
			//第一个参数是select语句中?的位置,默认从1开始
			statement.setString(1, username);
			statement.setString(2, pwd);
			//前面已经绑过小车了,这里不需要再次绑定
		    set = statement.executeQuery();
			//4.卸货
		    if (set.next()) {
				user = new User();
				user.setId(set.getString("id"));
				user.setName(set.getString("name"));
				user.setAge(set.getInt("age"));
				user.setPassword(set.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5.关闭资源
			DBUtil.closeAll(connection, statement, set);
		}

		return user;
	}

}
