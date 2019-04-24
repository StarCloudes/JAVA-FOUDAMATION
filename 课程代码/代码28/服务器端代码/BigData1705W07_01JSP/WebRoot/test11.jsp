<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式操作Collection,map</title>
</head>
<body>	
	<%
		List<String> phone = new ArrayList<String>();
		phone.add("iphone");
		phone.add("huawei");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("yi", "java");
		map.put("er", "php");
		
		
		//先将他们存入域对象
		pageContext.setAttribute("mylist", phone);
		pageContext.setAttribute("mymap", map);
	 %>
	 
	 <%--使用EL表达式取值 --%>
	 ${mylist }
	 ${mylist[0] }
	 ${mymap }
	 ${mymap.yi }
	 ${mymap["er"] }
	 
</body>
</html>