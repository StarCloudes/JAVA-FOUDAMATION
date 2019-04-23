package com.jadb.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jdbc.javabean.Emp;
import com.jdbc.util.DBUtil;

//异常处理
public class Demo5 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement =null;
		ResultSet set = null;
		try {
			connection = DBUtil.getConnection();
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
			DBUtil.closeAll(connection, statement, set);
		}	
	}
}
