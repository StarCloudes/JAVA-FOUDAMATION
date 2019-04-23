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
 * jdbc-将数据封装进模型:
 */
public class Demo3 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1.创建数据库的驱动---注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.创建连接--Connection对象
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123456");
		//3.创建小车,关联sql语句----statement对象
		Statement statement = connection.createStatement();
		String sql = "select empno,ename,job,sal from emp";
		ResultSet set = statement.executeQuery(sql);
		//4.卸货---ResultSet对象--描述的是查询的过程
		//List<Map<String, Object>> list = new ArrayList<>();
		List<Emp> list = new ArrayList<>();
		while (set.next()) {
//			Map<String, Object> map = new HashMap<>();
//			map.put("empno", set.getString("empno"));
//			map.put("ename", set.getString("ename"));
//			map.put("job", set.getString("job"));
//			map.put("sal", set.getDouble("sal"));
//			
//			list.add(map);
			Emp emp = new Emp();
			emp.setEmpno(set.getString("empno"));
			emp.setEname(set.getString("ename"));
			emp.setJob(set.getString("job"));
			emp.setSal(set.getDouble("sal"));
			list.add(emp);
		}
		System.out.println(list);
		//5.关闭资源
		connection.close();
		statement.close();
		set.close();
	}
}
