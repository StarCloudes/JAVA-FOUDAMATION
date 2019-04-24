<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本语法</title>
</head>
<body>
	<%!  
		//这里写的是java代码---全局变量
		int num = 5;
		
		public void play(){
			System.out.print(num);
			//out  这里不可以使用out,因为out是service方法内置的对象(变量)
		}
	 %>

	<%
	  //这里写的java代码---局部变量
	    Date date = new Date();
	    System.out.println(date);//控制台
	    out.print(date);//打印到浏览器
	    
	    //合理不能定义方法--因为现在已经在方法的内部
	    //调用方法
	    play();
	 %>
	 
	 <%=2+3 %><!-- 相当于 out.println(2+3) -->
	 
	 <!-- 注释 -->
	 <!--  html的注释 -->
	 <%--  jsp的注释 --%>
	 <%--jsp的注释:1.安全,2.省流量  所以尽量使用jsp的注释 --%>
</body>
</html>