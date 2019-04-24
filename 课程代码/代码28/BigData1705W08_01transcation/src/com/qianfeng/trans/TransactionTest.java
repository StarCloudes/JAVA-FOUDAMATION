package com.qianfeng.trans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qianfeng.util.DBUtil;

public class TransactionTest {
	public static void main(String[] args) {
		/*
		 * 事务:是逻辑上的一组操作,默认一个sql语句对应一个事务
		 * 
		 * 一个事务中操作的特点:要么全成功,要么全不成功--保持一致
		 */
		
		//张三借给李四1000元
		Connection connection = null;
		PreparedStatement pStatement  = null;
		try {
			connection = DBUtil.getConnection();
			
			//在开启事务之前可以手动设置隔离级别--最高级别
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			//手动开启事务--将默认的自动提交关闭,相当于开启了手动提交
			connection.setAutoCommit(false);
			//张三借钱
			String sql = "update acount set money=money-1000  where name=?";
			pStatement  = connection.prepareStatement(sql);
		    pStatement.setString(1, "zhangsan");
		    pStatement.executeUpdate();
		    
		    int num = 3/0;
		    
		    //李四收钱
		    sql = "update acount set money=money+1000  where name=?";
			pStatement  = connection.prepareStatement(sql);
		    pStatement.setString(1, "lisi");
		    pStatement.executeUpdate();
		    
		    //提交事务-将借钱与收钱手动放在一个事务中
		    connection.commit();
		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ArithmeticException e) {
			//当发生这个异常的时候,让事务回滚:让当前事务退回到开启事务之前,当前对事务的所有操作失效
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			DBUtil.closeAll(connection,pStatement , null);
		}
	}
}
