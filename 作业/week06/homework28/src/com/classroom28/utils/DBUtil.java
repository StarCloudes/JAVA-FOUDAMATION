package com.classroom28.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
	//成员变量
	static String myDriver;
	static String myUrl;
	static String myUer;
	static String myPwd;
	
	static { //只执行一次
		//**** 读取配置文件
		ResourceBundle bundle = ResourceBundle.getBundle("DBConfig");
	    myDriver = bundle.getString("driverClass");
	    myUrl = bundle.getString("url");
	    myUer = bundle.getString("user");
	    myPwd = bundle.getString("pwd");
	    
		try {
			Class.forName(myDriver);
			//Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static Connection getConnection() throws SQLException {	
		//return DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1","root","*****");
		
		return DriverManager.getConnection(myUrl,myUer,myPwd);
    }
    public static void closeAll(Connection connection,Statement statement,ResultSet set) {
    	if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        if(statement != null) {
        	try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        if(set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }				
    }
}
