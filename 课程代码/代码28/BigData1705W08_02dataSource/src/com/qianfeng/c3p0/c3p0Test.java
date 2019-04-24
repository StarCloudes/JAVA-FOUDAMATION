package com.qianfeng.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qianfeng.dbcp.DBCPUtil;

public class c3p0Test {
	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet set = null;
		try {
			connection = C3P0Util.getConnection();
			pStatement = connection.prepareStatement("select * from acount ");
			
			set = pStatement.executeQuery();
			
			while (set.next()) {
				System.out.println(set.getString("money"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCPUtil.release(connection, pStatement, set);
		}
	}
}
