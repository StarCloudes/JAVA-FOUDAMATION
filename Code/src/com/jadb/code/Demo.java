package com.jadb.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1 创建驱动 注册驱动
		//DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
		//使用反射
    	Class.forName("com.mysql.jdbc.Driver");
		//2 创建链接对象，使用jdbc里面的connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1","root","***");
		//3 创建小车，关联sql语句
		Statement statement = connection.createStatement();

//      查
//		String sql = "select ID,NAME,gender from emp";
//		ResultSet set = statement.executeQuery(sql);
//		//4 卸货 ResultSet
//		while(set.next()) {
//			Object object1 = set.getObject(1);	
//			Object object2 = set.getObject("NAME");
//			int int1 = set.getInt("ID");
//			String string1 = set.getString("NAME");
//			String string2 = set.getString("gender");
//			//System.out.println(object1);
//			System.out.println(int1 + "   " + string1 + "   "+ string2);
//		}
		
		//增删改
//		String sql = "insert into emp (NAME) values ('bing')";
//		int value = statement.executeUpdate(sql); //返回int型 0代表失败，非0代表成功
//		if(value > 0) {
//			System.out.println("success");
//		}else {
//			System.out.println("fail");
//		}
		
		//删除
//		String sql = "DELETE FROM emp where id=8;";
//		int value = statement.executeUpdate(sql); //返回int型 0代表失败，非0代表成功
//		if(value > 0) {
//			System.out.println("success");
//		}else {
//			System.out.println("fail");
//		}
		
		//修改
		String sql = "UPDATE emp SET name = 'qq' where id=7;";
		int value = statement.executeUpdate(sql); //返回int型 0代表失败，非0代表成功
		if(value > 0) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
		//关闭资源
		connection.close();
		statement.close();
		//set.close();
	}

}
