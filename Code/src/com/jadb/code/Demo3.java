package com.jadb.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jdbc.javabean.Emp;

//封装模型
public class Demo3 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1 创建驱动 注册驱动  使用反射
    	Class.forName("com.mysql.jdbc.Driver");
		//2 创建链接对象，使用jdbc里面的connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1","root","*****");
		//3 创建小车，关联sql语句
		Statement statement = connection.createStatement();
		String sql = "select ID,NAME,gender from emp";
		ResultSet set = statement.executeQuery(sql);
		//List<Map<String,Object>> list = new ArrayList<>();
		List<Emp> list = new ArrayList<>();
		//4 卸货 ResultSet
		while(set.next()) {
//			Map<String,Object> map = new HashMap<>();
//			map.put("ID", set.getInt("ID"));
//			map.put("NAME", set.getString("NAME"));
//			map.put("gender", set.getString("gender"));
//			list.add(map);
			
			Emp emp = new Emp();
			emp.setId(set.getInt("ID"));
			emp.setName(set.getString("NAME"));
			emp.setGender(set.getString("gender"));
			list.add(emp);	
		}
		System.out.println(list);

		//关闭资源
		connection.close();
		statement.close();
		set.close();
	}
}
