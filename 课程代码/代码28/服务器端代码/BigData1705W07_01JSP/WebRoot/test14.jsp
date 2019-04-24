<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--标准标签库的核心类库            prefix:使用标准标签库命令时的前缀  默认是c,我们也可以自定义  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标准标签库(JSTL的使用):用来处理jsp中的逻辑:循环,判断</title>
</head>
<body>
<%--
	JSTL和EL表达式都是要作用于4大域对象
	使用的前提:要先导入库
 --%>
 <%
 	int num = 4;
 	out.print(num);
  %>
  <%--第一个参数是变量的名字   第二个参数是对应的值 --%>
  <c:set var="num"  value="${4}"></c:set>
  <c:out value="${num }"></c:out>
  <c:remove var="num"/>
  <c:out value="${num }"  default="good"></c:out>
  
  <%-- 判断 --%>
  <%
  	if(true){
  	}
   %>
   
   <c:if test="${2<4 }">
             执行了
   </c:if>
   <%
    int num1 = 2;
    switch(num1){
    	case 0:
    	break;
    }
    %>
    <c:set var="b"  value="${2 }"></c:set>
    <c:choose>
      <c:when test="${b=='0' }">'0'</c:when>
      <c:when test="${b=='2' }">'2'</c:when>
      <c:when test="${b=='6' }">'6'</c:when>
    </c:choose>
   
</body>
</html>