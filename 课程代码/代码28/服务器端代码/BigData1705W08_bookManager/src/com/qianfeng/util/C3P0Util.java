package com.qianfeng.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * 注意事项:
 * 1.系统会自动读取c3p0-config.xml文件:a.文件的名字要固定-c3p0-config.xml   b.文件的位置也是固定的--src下面
 * 2.一般会自己创建xml配置文件,按照要求创建即可.
 * 3.优势:又有不需要自己关联配置文件,所以使用更方便
 */

public class C3P0Util {
	//1.创建池子(数据源)---创建了数据源之后,系统会自动添加连接
	private static ComboPooledDataSource dataSource =  new ComboPooledDataSource();
	//向池子中添加连接---系统会自动读取c3p0-config.xml文件:a.文件的名字要固定-c3p0-config.xml    b.文件的位置也是固定的--src下面
	//2.获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//获取数据源
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	//3.释放连接
	public static void release(Connection conn,PreparedStatement statement,ResultSet set) {
		if (conn != null) {
			
			try {
				conn.close();
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
