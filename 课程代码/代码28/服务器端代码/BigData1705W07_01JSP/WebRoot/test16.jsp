<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl--迭代器</title>
</head>
<body>
	 <%
	 	List<String> list = new ArrayList();
	 	list.add("java1");
	 	list.add("java2");
	 	list.add("java3");
	 	list.add("java4");
	 	list.add("java5");
	 	list.add("java6");
	 	list.add("java7");
	 	
	 	request.setAttribute("list", list);
	  %>
	  
	  <table border="1" width=3200px height=500px>
	  	<tr>
	  		<th>当前的元素</th>
	  		<th>应用字符串的对象</th>
	  		<th>遍历过的元素个数</th>
	  		<th>是否是第一个</th>
	  		<th>是否是最后一个</th>
	  	</tr>
	  	<c:forEach items="${list }" var="ss" varStatus="vs">
	  	<%--varStatus:他指向了一个字符串,这个字符串又引用了一个对象,将里面的属性称为变量状态参数,
	  	常用的值有5个
	  	count:到遍历的当前元素为止,遍历过的元素个数
	  	current:当前的元素
	  	index:当前元素的索引
	  	first:是否是第一个元素
	  	last:是否是最后一个元素
	  	 --%>
	  		<tr>
	  			<td>${ss }</td>
	  			<td>${vs }</td>
	  			<td>${vs.count }</td>
	  			<td>${vs.first }</td>
	  			<td>${vs.last }</td>
	  		</tr>
	  	</c:forEach>
	  
	  
	  </table>
</body>
</html>