<%@page import="com.qianfeng.entity.Dog"%>
<%@page import="com.qianfeng.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式:是一种规范,本身不是一种语言,jsp通过他可以简化代码</title>
</head>
<body>
	<%
	   request.setCharacterEncoding("utf-8");
	   
	   Person per = new Person();
	   per.setName("bingbing");
	   per.setAge(10);
	   
	   Dog dog = new Dog();
	   dog.setName("拉布拉多");
	
	   per.setDog(dog);
	   //将值存入域对象request
	   request.setAttribute("person", per);
	   request.getRequestDispatcher("/test10.jsp").forward(request, response);
	   
	 %>
</body>
</html>