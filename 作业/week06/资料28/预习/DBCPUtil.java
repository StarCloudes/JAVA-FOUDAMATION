package com.qianfeng.DBCP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/*
 * 1.导入三方架包
 * 2.编写配置文件:配置文件的类型必须是properties,名字随意,位置随意
 * 3.创建DBCPUtil工具类
 */

public class DBCPUtil {
	//1.创建数据源
	private static DataSource dataSource;
	//2.连接配置文件
	static{
		Properties properties = new Properties();
		try {
			//获取配置信息,将内容保存到properties对象里面
			properties.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//得到连接池对象,将配置信息指定给连接池对象
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//3.获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//4.释放连接
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
