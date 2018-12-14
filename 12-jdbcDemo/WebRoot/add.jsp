<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="utils.UUidUtils" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% 
  		//生成令牌
  		String code = UUidUtils.getCode();
  		//传给后端做判断  使用session
  		session.setAttribute("codetoken", code);
  			
  %>
    <form method="post" action="${pageContext.request.contextPath}/addServlet">
    	<input type="hidden" name="token" value=<%=code%>>
    	<table border="1" align="center" width="40%">
    		<tr>
    			<td>商品名称</td>
    			<td><input type="text" name="pname"></td>
    		</tr>
    		<tr>
    			<td>市场价</td>
    			<td><input type="text" name="market_price"></td>
    		</tr>
    		<tr>
    			<td>商城价</td>
    			<td><input type="text" name="shop_price"></td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td><input type="text" name="pdesc"></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="保存"></td>
    			
    		</tr>
    	</table>
    </form>
    
  </body>
</html>
