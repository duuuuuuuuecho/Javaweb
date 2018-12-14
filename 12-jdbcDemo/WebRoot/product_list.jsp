<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'product_list.jsp' starting page</title>
    
  </head>
  
  <body>
   <script type="text/javascript">
   //删除
  	function deleteP(obj){
  		
  		if(confirm("确定要删除吗？")){
  			location.href="${pageContext.request.contextPath }/deleteProductByidServlet?pid="+obj;
  		}
  		
  	}
  	//全选
  	function checkAll(obj){
  		var arr = document.getElementsByName("pid");
  	
  		for(var x =0 ; x<arr.length;x++){
  			arr[x].checked=obj.checked;
  				
  		}
  	
  	}
  	
  	//删除选中
   	function delCheck(){
   	//提交表单
   		document.getElementById("formId").submit();
   }
  
  </script>
  	<h1>这是所有的商品 </h1>
    
    <table border="1" align="center" width="88%">
    	<tr>
	    	<td colspan="7"> 
	    		<form action="${pageContext.request.contextPath }/findproductbyCondition" method="post">
	    		商品名称：<input  name="name">---
	    		关键字：<input name="key">
	    		<input type="submit" value="查询">
	    		</form>
	    	</td>
	    	<td colspan="1" align="right">
	    		<input  type="button" value="删除选中" onclick="delCheck()">
	    	</td>
    	</tr>
    	<tr>
    		<td align="center"><input type="checkbox" onclick="checkAll(this)"></td>
    		<td>序号</td>
    		<td>图片</td>
    		<td>名字</td>
    		<td>商城价</td>
    		<td>市场价</td>
    		<td>描述</td>
    		<td>操作</td>
    	</tr>
    	<form id="formId" action="${pageContext.request.contextPath }/deleteCheckServlet" method="post">
	   		<c:forEach items="${products}"  var="p">
		   		<tr>
		   			<td width="2%" align="center"><input type="checkbox" name="pid" value="${p.pid }"></td>
		    		<td width="8%">${p.pid }</td> 
		    		<td width="8%"><img src="${p.pimage }" width="80%"></td>
		    		<td width="8%">${p.pname }</td>
		    		<td width="8%">${p.shop_price }</td>
		    		<td width="8%">${p.market_price }</td>
		    		<td>${p.pdesc }</td>
		    		<td width="8%" align="center">
		    			<a href="${pageContext.request.contextPath }/findProductByidServlet?pid=${p.pid }">修改</a>
		    			
		    			<a href="javascript:void(0)" onclick="deleteP('${p.pid}')">删除</a>
		    		</td>
		    	</tr>
	   		 </c:forEach>
   		 </form>
    	
    
    </table>
  </body>
  

</html>
