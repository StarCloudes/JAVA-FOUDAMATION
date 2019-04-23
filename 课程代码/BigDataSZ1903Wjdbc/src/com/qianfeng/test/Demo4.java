package com.qianfeng.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qianfeng.javabean.Emp;

/*
 * jdbc-异常处理:
 */
public class Demo4 {
	public static void main(String[] args) {
		//1.创建数据库的驱动---注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.创建连接--Connection对象
		Connection connection = null;
		Statement statement = null;
		ResultSet set = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123456");
			//3.创建小车,关联sql语句----statement对象
			statement = connection.createStatement();
			String sql = "select empno,ename,job,sal from emp";
			set = statement.executeQuery(sql);
			//4.卸货---ResultSet对象--描述的是查询的过程
			List<Emp> list = new ArrayList<>();
			while (set.next()) {
				Emp emp = new Emp();
				emp.setEmpno(set.getString("empno"));
				emp.setEname(set.getString("ename"));
				emp.setJob(set.getString("job"));
				emp.setSal(set.getDouble("sal"));
				list.add(emp);
			}
			System.out.println(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
}
