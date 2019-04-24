<%@page import="com.qianfeng.entity.Dog"%>
<%@page import="com.qianfeng.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式</title>
</head>
<body>
	<%
		//通过java将值取出
		Person person = (Person)request.getAttribute("person");
		out.print(person.getName());
		Dog dog = person.getDog();
		out.print(dog.getName());
	
	 %>
	 <%--
	 	通过EL表达式将值取出来
	 	构成: ${域对象内键值对的key}     ${域对象内键值对的key.属性名字.属性的名字}
	 	注意点:1.类中必须有get,set方法   2.点后面的属性的名字必须跟类的成员变量的名字一致  
	 	3.如果在测试期间,对模型发生了改变,一定要重新发布
	 	
	 	注意:通过EL表达式只能操作4个域对象范围内的值
	  --%>
	 Person的对象:${person }
	 Person的姓名:${person.name }
	 Dog的姓名:${person.dog.name }
</body>
</html>