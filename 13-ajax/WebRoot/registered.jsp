<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
    <title>用户注册</title>
    
	<script type="text/javascript">
		$(function(){
			//给user框派发一个ajax事件，判断是否重复
			$("input[name='username']").blur(function(){
				var url="${pageContext.request.contextPath }/judgeServlet";
				var $param=$(this).val();
				
				$.get(url,"username="+$param,function(d){
					
					if(d==1){
					//存在
					$("#msg").html("<font color='red'>用户名已存在</font>");
					document.getElementById("btn").disabled=true;
					}else{
					//不存在
					$("#msg").html("<font color='green'>用户名可以使用</font>");
					document.getElementById("btn").disabled=false;
					
					}
					
				});
					
				
			})
		})
	
	
	</script>
  </head>
  
  <body>
   <form action="#" method="post">
   	<table>
   		<tr>
   			<td>用户名:</td>
   			<td><input type="text" name="username"></td>
   			<td><span id="msg"></span></td>
   		</tr>
   		<tr>
   			<td>密码:</td>
   			<td><input type="text" name="password"></td>
   			<td></td>
   		</tr>
   		<tr>
   			<td colspan="3"><input id="btn" type="button" value="注册"></td>
   		</tr>
   	</table>
   </form>
  </body>
</html>
