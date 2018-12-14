<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'transferAccount.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="${pageContext.request.contextPath}/accountServlet" method="post">
    	<table border="1">
    		<tr>
    			<td>转账人</td>
    			<td><input type="text" name="Auser" id="Auser"></td>
    		</tr>
    		<tr>
    			<td>收款人</td>
    			<td><input type="text" name="Buser" id="Buser"></td>
    		</tr>
    		<tr>
    			<td>转账金额</td>
    			<td><input type="text" name="money" id="money"></td>
    		</tr>		
    	</table>
    	<button type="submit" onclick="return checkit()">转账</button>  
    </form>
  </body>
  <script type="text/javascript">
  	function checkit(){
  		
  		var a = document.getElementById("Auser");
  		var b = document.getElementById("Buser");
  		var m = document.getElementById("money");
  		
  		if(a.value == ""){
  		alert("转账人不能为空");
  		return false;
  		}
  		if(b.value == ""){
  		alert("收账人不能为空");
  		return false;
  		}
  		if(m.value == ""){
  		alert("金钱不能为空");
  		return false;
  		}
  		
  		
  	}
  
  </script>
</html>
