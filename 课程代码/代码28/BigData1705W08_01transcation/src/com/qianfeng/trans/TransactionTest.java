package com.qianfeng.trans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qianfeng.util.DBUtil;

public class TransactionTest {
	public static void main(String[] args) {
		/*
		 * ����:���߼��ϵ�һ�����,Ĭ��һ��sql����Ӧһ������
		 * 
		 * һ�������в������ص�:Ҫôȫ�ɹ�,Ҫôȫ���ɹ�--����һ��
		 */
		
		//�����������1000Ԫ
		Connection connection = null;
		PreparedStatement pStatement  = null;
		try {
			connection = DBUtil.getConnection();
			
			//�ڿ�������֮ǰ�����ֶ����ø��뼶��--��߼���
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			//�ֶ���������--��Ĭ�ϵ��Զ��ύ�ر�,�൱�ڿ������ֶ��ύ
			connection.setAutoCommit(false);
			//������Ǯ
			String sql = "update acount set money=money-1000  where name=?";
			pStatement  = connection.prepareStatement(sql);
		    pStatement.setString(1, "zhangsan");
		    pStatement.executeUpdate();
		    
		    int num = 3/0;
		    
		    //������Ǯ
		    sql = "update acount set money=money+1000  where name=?";
			pStatement  = connection.prepareStatement(sql);
		    pStatement.setString(1, "lisi");
		    pStatement.executeUpdate();
		    
		    //�ύ����-����Ǯ����Ǯ�ֶ�����һ��������
		    connection.commit();
		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ArithmeticException e) {
			//����������쳣��ʱ��,������ع�:�õ�ǰ�����˻ص���������֮ǰ,��ǰ����������в���ʧЧ
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
