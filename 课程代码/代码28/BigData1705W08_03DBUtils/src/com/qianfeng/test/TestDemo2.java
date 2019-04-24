package com.qianfeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.qianfeng.domain.User;
import com.qianfeng.util.C3P0Util;

public class TestDemo2 {
	/*
	 * ResultSetHandler接口
	 */
	@SuppressWarnings("unchecked")
	//@Test
	//获取全部的数据
	public void test1() throws SQLException{
		QueryRunner qRunner2 = new QueryRunner(C3P0Util.getDataSource());
		
		ResultSetHandler handler = 
		new ResultSetHandler<List<User>>() {

			/*
			 * 这是真正处理数据的方法
			 * 参数就是得到的结果集
			 * 这个方法会被自动调用
			 */
			@Override
			public List<User> handle(ResultSet set) throws SQLException {
				List<User> list = new ArrayList<User>();
				
				while (set.next()) {
					User user = new User();
					user.setName(set.getString("name"));
					user.setPassword(set.getString("password"));
					
					list.add(user);
				}
				
				return list;
			}
		};
		
		List<User> list = qRunner2.query("select * from user", handler);
		
		System.out.println(list);
	}
	
	//@Test
	//返回所有的数据--将记录装入模型,将模型装入list
	
	public void test2() throws SQLException{
		QueryRunner qRunner2 = new QueryRunner(C3P0Util.getDataSource());
																				//<对应模型的类>(模型的字节码文件)
		List<User> list = qRunner2.query("select * from user", new BeanListHandler<User>(User.class));
		System.out.println(list);
	}
	
	@Test
	//返回一条记录-得到的是模型
	public void test3() throws SQLException{
		QueryRunner qRunner2 = new QueryRunner(C3P0Util.getDataSource());
		User user = qRunner2.query("select * from user where id=?", new BeanHandler<User>(User.class),1);
		System.out.println(user);
	}
	
	//取一条记录
	//ArrayHandler:只能返回一个记录,并且没有存储到javabean中,默认返回的是第一个记录
	//@Test
	public void test13() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		//
		Object[] objects = qRunner.query("select * from user", new ArrayHandler());
		
		for (Object object : objects) {
			System.out.println(object);
		}
	}
	
	
	//取多条记录
	//ArrayListHandler:可以返回查到的多行记录,将一条记录的每个字段存储到一个数组中,再将这些数组放入一个集合中,并返回
	//@Test
	public void test4() throws SQLException{
		
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		
		List<Object[]> list = qRunner.query("select * from user", new ArrayListHandler());
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"  ");
			}
			System.out.println();
		}
		
	}
	
	//ColumnListHandler:根据指定的列数,取某一列的数据,封装到list中返回
	//@Test
	public void test5() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		//参数的意思是:指定查询的列号---从1开始计数
		List<Object> list = qRunner.query("select * from user", new ColumnListHandler(2));
		
		for (Object object : list) {
			System.out.print(object+"  ");
		}
	}
	
	//KeyedHandler:可以取多条记录,每一条记录被封装在了map中,然后再将所有的map对象放在一个大的map中,让每条记录中的某个字段充当外层map的key
	//注意:如果充当key的字段有重复,和面的记录会将前面所有的记录覆盖
	//@Test
	public void test6() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		
		Map<Object, Map<String, Object>> map=qRunner.query("select * from user", new KeyedHandler(5));
		
		for(Map.Entry<Object, Map<String, Object>> en:map.entrySet()){
			Object key = en.getKey();
			Map<String, Object> subMap = en.getValue();
			
			for(Map.Entry<String, Object> suben:subMap.entrySet()){
				String subkey = suben.getKey();
				Object value = suben.getValue();
				
				System.out.print(subkey+"="+value+"   ");
			}
			System.out.println("  key="+key);
		}
	}
	
	//只能取一条记录
	//MapHandler:将一条记录的字段和对应的值封装到一个map中,返回,默认取的是第一行
	//@Test
	public void test7() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		
		Map<String, Object> map = qRunner.query("select * from user", new MapHandler());
		
		for(String key:map.keySet()){
			System.out.print(key+"="+map.get(key)+"   ");
		}
	}
	
	
	//MapHandler:将一条记录的字段和对应的值封装到一个map中,再将所有的map放到一个list中并返回
	//@Test
	public void test8() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		List<Map<String, Object>> list = qRunner.query("select * from user", new MapListHandler());
		
		for (Map<String, Object> map : list) {
			for(String key:map.keySet()){
				System.out.print(key+"="+map.get(key)+"   ");
			}
			
			System.out.println();
		}
	}
	
	//取第一行的某一列的值
	//ScalarHandler:适合取单行单列的数据
	@Test
	public void test9() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		//参数:代表第一行对应的行号,取这个列下的数据,若果不写,默认取第一列
		//Object object = qRunner.query("select * from user", new ScalarHandler(3));
		//与聚合函数联合使用,参数可以取的列是select后面可以获取的列数
		Object object1 = qRunner.query("select *,count(*) from user", new ScalarHandler(6));
		System.out.println(object1);
	}
}
