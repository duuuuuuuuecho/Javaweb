<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
    <base href="<%=basePath%>">
   <script type="text/javascript">
   	$(function(){
   		//文本框keyup的时候   发送ajax
   		$("#kw").keyup(function(){
   			//获取文本框的值
   			var $value=$(this).val();
   			
   			if($value!=null && $value !=''){
   			$("#kws").html("");
   				$.post("${pageContext.request.contextPath}/searchkwServlet","keyword="+$value,function(d){
   					if(d!=''){
   						
   						var arr= d.split(",");
   						$(arr).each(function(){
   							//将每一个值放入一个div中  并插入到kws中
   							$("#kws").append($("<div>"+this+"</div>"));	
   						});
   						//将div显示
   						$("#kws").show();
   						
   					}
   				
   				});
   			}else{
   				$("#kws").hide();
   			} 
   			
   			
   		});   	
   	})
   
   </script>


  </head>
  
  <body>
  <center>
	    
	    <h1>搜索</h1>
	    <div>
	    <input type="text" name="keyword" id="kw" style="width:500px"><input type="submit" value="搜索"> 
	    </div>
	    <div id="kws" style="border: 1px solid red;width:499px;position:relative;left:-21px;display:none"></div>
    </center>
  </body>
</html>
