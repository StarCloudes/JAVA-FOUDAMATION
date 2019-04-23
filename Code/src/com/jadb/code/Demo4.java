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

//异常处理
public class Demo4 {
	public static void main(String[] args) {
		//1 创建驱动 注册驱动  使用反射
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2 创建链接对象，使用jdbc里面的connection
		Connection connection = null;
		Statement statement =null;
		ResultSet set = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1","root","*****");
			//3 创建小车，关联sql语句
			statement = connection.createStatement();
			String sql = "select ID,NAME,gender from emp";
			set = statement.executeQuery(sql);
			//List<Map<String,Object>> list = new ArrayList<>();
			List<Emp> list = new ArrayList<>();
			//4 卸货 ResultSet
			while(set.next()) {
				Emp emp = new Emp();
				emp.setId(set.getInt("ID"));
				emp.setName(set.getString("NAME"));
				emp.setGender(set.getString("gender"));
				list.add(emp);	
			}
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 	//关闭资源
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
            if(connection != null) {
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
}
