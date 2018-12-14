<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"> </script>
    <title>ajax ：入门</title>
    <script type="text/javascript">
    	$(function(){
    	
    		$("#btn1").click(function(){
    		
    			var url="${pageContext.request.contextPath }/ajaxdemoServlet";
    			var param={"username":"张三"};
    		
    			//了解:jquery对象.load(url,params,function(数据){});
    			$(this).load(url,param,function(d){
    				alert(d);
    			});
    		});
    		
    		$("#btn2").click(function(){
    		
    			var url="${pageContext.request.contextPath }/ajaxdemoServlet";
    			var param={"username":"李四"};
    		
    			//get
    			$.get(url,param,function(d){
    				alert(d);
    			});
    			
    		});
    		
    		$("#btn3").click(function(){
    		
    			var url="${pageContext.request.contextPath }/ajaxdemoServlet";
    			var param={"username":"王五"};
    		
    			//post
    			$.post(url,param,function(d){
    				alert(d.msg);
    			},"json");
    			
    		});
    	
    		$("#btn4").click(function(){
    		
	    			var url="${pageContext.request.contextPath }/ajaxdemoServlet";
	    			var param={"username":"杜爸爸"};
	    			
		    		$.ajax({
		    			url:url,
		    			type:"post",
		    			data:param,
		    			success:function(d){alert(d.msg)},
		    			error:function(){},
		    			dataType:"json"
		    		
		    		});
    			
    		});
    	
    })
    	
    </script>
    
  </head>
  
  <body>
    <input type="button" id="btn1" value="点我发送load_ajax">
    <hr>
    <input type="button" id="btn2" value="点我发送get_ajax">
    <hr>
    <input type="button" id="btn3" value="点我发送post_ajax">
    <hr>
    <input type="button" id="btn4" value="点我发送ajax">
    
  </body>
</html>
