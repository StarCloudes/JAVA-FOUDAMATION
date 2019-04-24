package com.qianfeng.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * ע������:
 * 1.ϵͳ���Զ���ȡc3p0-config.xml�ļ�:a.�ļ�������Ҫ�̶�-c3p0-config.xml   b.�ļ���λ��Ҳ�ǹ̶���--src����
 * 2.һ����Լ�����xml�����ļ�,����Ҫ�󴴽�����.
 * 3.����:���в���Ҫ�Լ����������ļ�,����ʹ�ø�����
 */

public class C3P0Util {
	//1.��������(����Դ)---����������Դ֮��,ϵͳ���Զ��������
	private static ComboPooledDataSource dataSource =  new ComboPooledDataSource();
	//��������������---ϵͳ���Զ���ȡc3p0-config.xml�ļ�:a.�ļ�������Ҫ�̶�-c3p0-config.xml    b.�ļ���λ��Ҳ�ǹ̶���--src����
	//2.��ȡ����
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//��ȡ����Դ
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	//3.�ͷ�����
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
