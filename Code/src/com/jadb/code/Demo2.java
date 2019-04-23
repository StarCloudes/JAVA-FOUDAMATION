package com.jadb.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Demo2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1 创建驱动 注册驱动
		//DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
		//使用反射
    	Class.forName("com.mysql.jdbc.Driver");
    	//2 创建链接对象，使用jdbc里面的connection
    	Properties properties = new Properties();
    	properties.setProperty("user", "root");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1","root","*****");
		//3 创建小车，关联sql语句
		Statement statement = connection.createStatement();
		String sql = "select ID,NAME,gender from emp";
		ResultSet set = statement.executeQuery(sql);
		//4 卸货 ResultSet
		while(set.next()) {
			Object object1 = set.getObject(1);	
			Object object2 = set.getObject("NAME");
			int int1 = set.getInt("ID");
			String string1 = set.getString("NAME");
			String string2 = set.getString("gender");
			//System.out.println(object1);
			System.out.println(int1 + "   " + string1 + "   "+ string2);
		}
		//关闭资源
		connection.close();
		statement.close();
		set.close();
	}
}
