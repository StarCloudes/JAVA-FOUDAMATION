package com.qianfeng.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
	//成员变量接收传过来的值
	static String myDriver;
	static String myUrl;
	static String myUser;
	static String myPwd;
	static {
		//读取properties文件的内容
		ResourceBundle bundle = ResourceBundle.getBundle("DBConfig");//1.这里不需要写路径(默认路径是当前的工程),
																	//2.不需要写后缀名
		myDriver = bundle.getString("driverClass");
		myUrl = bundle.getString("url");
		myUser = bundle.getString("user");
		myPwd = bundle.getString("pwd");
		
		//1.创建数据库的驱动---注册驱动
		try {
			Class.forName(myDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接对象
	public static Connection getConnection() throws SQLException {
		//2.创建连接--Connection对象
		return DriverManager.getConnection(myUrl, myUser, myPwd);
	}
	
	public static void closeAll(Connection connection,Statement statement,ResultSet set) {
		//5.关闭资源
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
