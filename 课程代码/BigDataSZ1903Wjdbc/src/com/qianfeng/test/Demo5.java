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
import com.qianfeng.utils.DBUtil;

/*
 * jdbc-代码再封装:
 * 
 * 明天的内容:
 * 1.模拟登陆---解决sql注入问题
 * 2.xml的讲解
 * 3.事务
 * 4.连接池基础
 * 5.DBCP和C3P0三方连接池
 * 6.创建web工程
 * 7.DBUtils工具类
 */
public class Demo5 {
	public static void main(String[] args) {
		//1.创建数据库的驱动---注册驱动
		//2.创建连接--Connection对象
		Connection connection = null;
		Statement statement = null;
		ResultSet set = null;
		try {
			connection = DBUtil.getConnection();
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
			DBUtil.closeAll(connection, statement, set);
		}
		
	}
}
