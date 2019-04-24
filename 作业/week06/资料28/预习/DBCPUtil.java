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
 * 1.���������ܰ�
 * 2.��д�����ļ�:�����ļ������ͱ�����properties,��������,λ������
 * 3.����DBCPUtil������
 */

public class DBCPUtil {
	//1.��������Դ
	private static DataSource dataSource;
	//2.���������ļ�
	static{
		Properties properties = new Properties();
		try {
			//��ȡ������Ϣ,�����ݱ��浽properties��������
			properties.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�õ����ӳض���,��������Ϣָ�������ӳض���
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//3.��ȡ����
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//4.�ͷ�����
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
