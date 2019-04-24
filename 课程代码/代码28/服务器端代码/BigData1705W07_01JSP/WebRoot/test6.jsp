<%@page import="com.qianfeng.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>六大动作:创建对象</title>
</head>
<body>
	<%
		Person person = new Person();
		person.setName("张三");
		out.print(person.getName());
	 %>
	 
	 <%--jsp创建对象
	           这里是利用反射创建对象
	 	id:代表对象的名字        class:包名+类名
	  --%>
	 <jsp:useBean id="person1"  class="com.qianfeng.entity.Person"></jsp:useBean>
	 <%-- property:属性的名字   name:属性对应的对象的名字    value:是对应的值 --%>
	 <jsp:setProperty property="name" name="person1" value="李四" />
	 <jsp:getProperty property="name" name="person1"/><%--这里会将得到的值直接写入浏览器 --%>
</body>
</html>