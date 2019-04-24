<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL:循环</title>
</head>
<body>
	<%  
		//for循环   
		for(int i=0;i<4;i++){
			out.print(i);
		}
	 %>
	 <%-- 第一个参数:初使变量    第二个:开始值   第三个:结束值    第四个:自变量   注意:包括开始和结束--%>
	 <c:forEach var="i" begin="0"  end="4" step="1">
	 	${i }
	 </c:forEach>
	 
	 <%--增强for循环 --%>
	 <%-- for(元素:集合){} --%>
	 <%
	 	List<String> list = new ArrayList<String>();
	 	list.add("java1");
	 	list.add("java2");
	 	list.add("java3");
	 	list.add("java4");
	 	
	 	request.setAttribute("mylist", list);
	  %>
	  <%--第一个:当前的集合    第二个:一个元素 --%> 
	  <c:forEach items="${mylist }" var="aa">
	     ${aa }
	  </c:forEach>
</body>
</html>