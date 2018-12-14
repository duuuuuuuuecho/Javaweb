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
    
    <title>分页查询</title>
 

  </head>
  
  <body>
  <table border="1" align="center" width="88%">
   		<tr>
    		
    		<td>序号</td>
    		<td>图片</td>
    		<td>名字</td>
    		<td>商城价</td>
    		<td>市场价</td>
    		<td>描述</td>
    		
    	</tr>
    	
	   		<c:forEach items="${PBean.list}"  var="p">
		   		<tr>
		    		<td width="8%">${p.pid }</td> 
		    		<td width="8%"><img src="${p.pimage }" width="80%"></td>
		    		<td width="8%">${p.pname }</td>
		    		<td width="8%">${p.shop_price }</td>
		    		<td width="8%">${p.market_price }</td>
		    		<td>${p.pdesc }</td>
		    	</tr>
	   		 </c:forEach>
   		
   </table>
   <center>
   		<!-- 若是第一页 首页与上一页不展示 -->
   		<c:if test="${PBean.currPage!=1}">
   		<a href="${pageContext.request.contextPath}/showProductByPageServlet?currPage=1">[首页]</a>	
   		<a href="${pageContext.request.contextPath}/showProductByPageServlet?currPage=${PBean.currPage-1}">[上一页]</a>	
   		</c:if>	
   		<!--展示所有页码 -->
   		<c:forEach begin="1" end="${PBean.totalPage }" var="p" step="1" >
   			<c:if test="${p!= PBean.currPage}">
   				<a href="${pageContext.request.contextPath}/showProductByPageServlet?currPage=${p}">${p }</a>	
   			</c:if>
   			<c:if test="${p== PBean.currPage}">
   				${p }
   			</c:if>
   		</c:forEach>
   		
   		<!-- 若是最后一页 尾页与下一页不展示 -->
   		<c:if test="${PBean.currPage!=PBean.totalPage}">
   		<a href="${pageContext.request.contextPath}/showProductByPageServlet?currPage=${PBean.currPage+1}">[下一页]</a>		
   		<a href="${pageContext.request.contextPath}/showProductByPageServlet?currPage=${PBean.totalPage}">[尾页]</a>	
   		</c:if>
   		第${PBean.currPage}页/共${PBean.totalPage }页
   </center>
   
  </body>
</html>
