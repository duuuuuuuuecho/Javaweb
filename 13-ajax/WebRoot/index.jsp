<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  
  
  
  <body>
  <hr/>
   <a href="${pageContext.request.contextPath }/ajaxdemo.jsp" >ajax入门</a> <hr/>
    <a href="${pageContext.request.contextPath }/registered.jsp" >ajax注册</a> <hr/>
    <a href="${pageContext.request.contextPath }/search.jsp" >ajax模拟百度搜索</a> <hr/>
    <a href="${pageContext.request.contextPath }/provinceCity.jsp" >ajax省市联动</a> <hr/>
    
  </body>
</html>
