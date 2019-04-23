package com.qianfeng.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc的基础:
 *  * 准备工作:
 * 1.导入数据库驱动的架包(.jar文件)
 * 2.要对架包进行buildPath操作
 * 3.建立代码实现的数据库的访问
 */
public class Demo1 {
	public static void main(String[] args) throws SQLException {
		//1.创建数据库的驱动---注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2.创建连接--Connection对象
		//三个参数的
		/*
		 * 第一个参数:数据库的访问路径
		 * 第二个参数:用户名
		 * 第三个参数:密码
		 */
		//这里使用jdbc里面的Connection,增加扩展性
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123456");
		//3.创建小车,关联sql语句----statement对象
		Statement statement = connection.createStatement();
		String sql = "select empno,ename,job,sal from emp";
		ResultSet set = statement.executeQuery(sql);
		//4.卸货---ResultSet对象--描述的是查询的过程
		while (set.next()) {//开始指针指向表头,调用next方法会使指针向下移动一行,判断当前行是否有数据,如果有,返回true,没有返回false
			//通过下标获取值,注意:这里下标默认从1开始,这里的顺序跟虚拟机中的字段顺序一致(即 select 语句中字段顺序一致)
//			Object object1 =  set.getObject(1);
//			//通过字段名字获取对应的值
//			Object object2 = set.getObject("empno");
//			System.out.println(object1+"      "+object2);
			String empno = set.getString("empno");
			String ename = set.getString("ename");
			String job = set.getString("job");
			double sal = set.getDouble("sal");
			System.out.println("编号:"+empno+"    名字:"+ename+"    工作:"+job+"    工资:"+sal);
		}
		//5.关闭资源
		connection.close();
		statement.close();
		set.close();
	}
}
