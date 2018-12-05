<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is 购物车 page. <br>
    
    
    <table border="1" align="center" width="20%">
    	<tr>
    		<td>商品名称</td>
    		<td>商品数量</td>
    	</tr>
    <% 
    	//获取购物车
    	Map<String,Integer> map= (Map<String,Integer>)session.getAttribute("cart");
    
    	
    	//判断购物车中是否空
    	//非空 则遍历
    	
    	if(map==null){
   	 %>
   	 	<tr><td colspan='2'>购物车空空的鸭</td></tr>
    <% 
    	}else{
    	for(String name:map.keySet()){
    		%>
    			<tr>
    			<td><%=name%></td>
    			<td><%=map.get(name)%></td>
    			</tr>
    		<% 
    	}
    }
    %>
    
    </table>
    <hr/>
    <center>
    <a href="/09-cookieSession/product_list.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/09-cookieSession/clearcartServlet">清空购物车</a>
    </center>
   
  </body>
</html>
