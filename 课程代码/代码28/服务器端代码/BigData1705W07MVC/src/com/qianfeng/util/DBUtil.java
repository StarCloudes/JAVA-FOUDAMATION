package com.qianfeng.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



public class DBUtil {
	private static String dClass;
	private static String myurl;
	private static String myuser;
	private static String pwd;
	
	static{
		//��ȡproperties�ļ�
		//Ĭ�϶�ȡ��·����src
		ResourceBundle rBundle = ResourceBundle.getBundle("DBConfig");
		dClass = rBundle.getString("driverClass");
		myurl = rBundle.getString("url");
		myuser = rBundle.getString("user");
		pwd = rBundle.getString("password");
		
		
		//1.ע������
		//���÷���
		try {
			Class.forName(dClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	//�����������������ݿ�
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(myurl, myuser, pwd);
	}
	//�ر���Դ
	public static void closeAll(Connection connection,Statement statement,ResultSet set) {
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
