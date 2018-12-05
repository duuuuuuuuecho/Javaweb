<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <a href="${pageContext.request.contextPath}/jstl/if.jsp">跳转jstl——core_if标签</a><br>
    <a href="${pageContext.request.contextPath}/jstl/forEach.jsp">跳转jstl——forEach标签</a><br>
    <a href="${pageContext.request.contextPath}/findAllServlet">展示所有商品</a><br>
  </body>
</html>
