package com.qianfeng.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.qianfeng.util.C3P0Util;

/*
 * @Test:他下面的方法是测试的方法,这个方法可以直接被调用,但是必须是在测试的环境下
 * 注意点:1.方法不能有参数  2.不能有返回值
 */
public class TestDemo1 {
	//@Test
	public void test1(){
		Connection connection = null;
		PreparedStatement pStatement = null;
		int num = 0;
		try {
			connection = C3P0Util.getConnection();
			String sql = "insert into user(id,name,password) values(?,?,?)";
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setInt(1, 4);
			pStatement.setString(2, "王五");
			pStatement.setString(3, "123");
			
			num = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Util.release(connection, pStatement, null);
		}
	}
	
	//使用DBUtis实现插入
	//@Test
	public void  test2() throws SQLException{
		//写sql语句
		String sql = "insert into user(id,name,password) values(?,?,?)";
		
		//第一种:使用的是无参的QueryRunner()方法----为了更加方便的使用事务,因为可以直接获取到Connection对象
		//1.创建干活的的对象--QueryRunner
		QueryRunner qRunner = new QueryRunner();
		//2.获取连接对象
		Connection connection = C3P0Util.getConnection();
		//3.调用update()方法实现对数据库的访问
		int num = qRunner.update(connection, sql,6,"马六","345");
		if (num >0) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
		
		//第二种:使用的是有参的QueryRunner()方法--参数是数据源
		//1.创建干活儿的对象并绑定数据源
		QueryRunner qRunner2 = new QueryRunner(C3P0Util.getDataSource());
		//2.调用update()方法
		int num2 = qRunner2.update(sql,7,"马六1","3451");
		if (num2 >0) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
	}
	
	//批量增加--只能同时执行一种操作
	@Test
	public void test3() throws SQLException{
		QueryRunner qRunner2 = new QueryRunner(C3P0Util.getDataSource());
		
		//创建一个二维数组装 数据
		Object[][] params = new Object[3][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{i+8,"bingbing"+i,"333"+i};
		}
		
		//写sql语句
	    String sql = "insert into user(id,name,password) values(?,?,?)";
		int[] nums = qRunner2.batch(sql, params);
	}
}
