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
    
    <title>修改商品</title>
  
  </head>
  
  <body>

    <form method="post" action="${pageContext.request.contextPath}/editServlet">
    	
    	<input type="hidden" name="pid" value="${f_product.pid }">
    	<table border="1" align="center" width="40%">
    		<tr>
    			<td>商品名称</td>
    			<td><input type="text" name="pname" value="${f_product.pname }"></td>
    		</tr>
    		<tr>
    			<td>市场价</td>
    			<td><input type="text" name="market_price" value="${f_product.market_price }"></td>
    		</tr>
    		<tr>
    			<td>商城价</td>
    			<td><input type="text" name="shop_price" value="${f_product.shop_price }"></td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td><input type="text" name="pdesc" value="${f_product.pdesc }"></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="保存"></td>
    			
    		</tr>
    	</table>
    </form>
    
  </body>
</html>
