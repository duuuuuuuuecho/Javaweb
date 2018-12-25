<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	

  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/loginServlet" method="post">
	   	<table align="left" >
	   		<tr>
	   			<td>用户名：</td>
	   			<td><input type="text" name="username"></td>
	   		</tr>
	   		<tr>
	   			<td>密码：</td>
	   			<td><input type="text" name="password"></td>
	   		</tr>
	   		<tr>
	   			<td ><input type="checkbox" name="savename" value="ok">记住用户名</td>
	   			<td ><input type="checkbox" name="autologin" value="ok">自动登录</td>
	   		</tr>
	   		<tr>
	   			<td colspan="2"><input type="submit" value="登录"></td>
	   		</tr>
	   	</table>
   </form>
  </body>
  <script type="text/javascript">
 		onload=function(){
	 		var s = "${cookie.autoname.value }";
	 		s = decodeURI(s)
	 		document.getElementsByName("username")[0].value=s;
 		}
 	
 	
  </script>
</html>
