<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'encode.jsp' starting page</title>
    
	

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/encodeServlet">
    	<table>
    		用户名：<input type="text" name="name">
    		密码：<input type="text" name="password">
    		<input type="submit">
    	</table>
    </form>
  </body>
</html>
