<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product_list.jsp' starting page</title>
    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
   <hr>
   <table border="1">
   	<tr>
   		<td>id</td>
   		<td>名字</td>
   		<td>价格</td>
   		<td>描述</td>
   	</tr>
  	
  	   <c:forEach items="${product_list}" var="p">   
  	   <tr >
	   		<td>${p.id}</td>
	   		<td>${p.pname}</td>
	   		<td>${p.price}</td>
	   		<td>${p.pdesc}</td>
	   	</tr>
       </c:forEach>
   	
   
   </table> 
   
  </body>
</html>
