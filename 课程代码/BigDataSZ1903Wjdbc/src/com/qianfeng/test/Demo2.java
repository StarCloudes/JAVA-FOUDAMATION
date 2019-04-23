package com.qianfeng.test;

import java.security.Permissions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * jdbc的改进
 */
public class Demo2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1.创建数据库的驱动---注册驱动
		//使用反射注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.创建连接--Connection对象
		//三个参数的
		/*
		 * 第一个参数:数据库的访问路径
		 * 第二个参数:用户名
		 * 第三个参数:密码
		 */
		//这里使用jdbc里面的Connection,增加扩展性
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123456");
		//两个参数
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "123456");
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", properties);
		//一个参数
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?user=root&password=123456");
		//3.创建小车,关联sql语句----statement对象
		Statement statement = connection.createStatement();
		
		//查
//		String sql = "select empno,ename,job,sal from emp";
//		ResultSet set = statement.executeQuery(sql);
//		//4.卸货---ResultSet对象--描述的是查询的过程
//		while (set.next()) {//开始指针指向表头,调用next方法会使指针向下移动一行,判断当前行是否有数据,如果有,返回true,没有返回false
//			//通过下标获取值,注意:这里下标默认从1开始,这里的顺序跟虚拟机中的字段顺序一致(即 select 语句中字段顺序一致)
////			Object object1 =  set.getObject(1);
////			//通过字段名字获取对应的值
////			Object object2 = set.getObject("empno");
////			System.out.println(object1+"      "+object2);
//			String empno = set.getString("empno");
//			String ename = set.getString("ename");
//			String job = set.getString("job");
//			double sal = set.getDouble("sal");
//			System.out.println("编号:"+empno+"    名字:"+ename+"    工作:"+job+"    工资:"+sal);
//		}
		//增删改
		//增加
		String sql = "insert into emp(ename) values('bingbing')";
		//statement.executeQuery(arg0);//只能用于查询
		//返回值是0代表失败,非零代表成功
		int value = statement.executeUpdate(sql);//用于增删改
		if (value > 0) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
		
		//删除--练习
		//修改--练习
		//5.关闭资源
		connection.close();
		statement.close();
		//set.close();
	}
}
