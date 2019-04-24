package com.qianfeng.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCPTest {
	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet set = null;
		try {
			connection = DBCPUtil.getConnection();
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
