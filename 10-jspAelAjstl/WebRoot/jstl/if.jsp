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
    
    <title>My JSP 'if.jsp' starting page</title>
  </head>
  
  <body>
  <hr>
    哈哈<br>
    
    <c:if test="${3>4}">3大于4</c:if>
    <c:if test="${4>3}">4大于3</c:if>
  
    </body>
</html>
