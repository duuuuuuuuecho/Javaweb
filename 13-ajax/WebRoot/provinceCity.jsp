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
  		//页面加载成功  查询所有的省
  		$.get("${pageContext.request.contextPath }/selectProServlet",function(d){
  			var $pro = $("#proId");
  			$(d).each(function() {
  			
  				$pro.append($("<option value="+this.provinceID+">"+this.name+"</option>"));
  					
  			});
  			
  		},"json");
  		
  		
  		//给省份改变派发时间  
  		$("#proId").change(function(){
  		
  			var $id = $(this).val();
  			if($id==0){
  				var $ct = $("#cityId");
	  			$ct.html("<option>--城市--</option>");
  			}			
	  		$.get("${pageContext.request.contextPath }/selectCityServlet",{"id":$id},function(d){
	  			
	  			var $ct = $("#cityId");
	  			$ct.html("<option>--城市--</option>");
	  			
	  			if(d!=null){
		  			
		  			$(d).each(function(){
		  			
		  				$ct.append($("<option>"+this.name+"</option>"));
		  			
		  			});
	  			}
	  			
	  			
	  			
	  		},"json");
  		})
  		
  		
  		
  	})
  
  </script>  
    <title>省市联动</title>
    
  </head>
  	<select id="proId" name="province">
  		<option value=0>--省份--</option>
  	</select>
  	<select id="cityId" name="city">
  		<option>--城市--</option>
  	</select>
  <body>
    
  </body>
</html>
