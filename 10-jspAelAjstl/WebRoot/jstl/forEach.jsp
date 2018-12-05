<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forEach.jsp' starting page</title>
   </head>
  
  <body>
    基础用法<br>
    在页面上输出一到十 <br>
   
    <c:forEach begin="1" end="10" step="1" var="i">${i  }</c:forEach>
     <hr>
    基础用法<br>
  在页面上输出一到二十中的奇数 <br>
  	<c:forEach begin="1" end="20" step="2" var="i" varStatus="vs">
  	输出${i}---
  	第几次输出${vs.count}---
  	当前输出${vs.current }<br>
  	
  	</c:forEach>
  	<hr>
  	
  	    高级用法<br>
  	    从数组中取出元素<br>
  	
  	<%
  		List l =new ArrayList();
  		l.add("12");
  		l.add("23");
  		l.add("hahah");
  		request.setAttribute("shuzu", l);
  	
  		
  		
  	
  	 %>
  	<c:forEach items="${shuzu }" var="n">${n }</c:forEach>
  	<hr>
  	
  	    高级用法<br>
  	    从map中取出元素<br>
  		<% 
  		Map mp = new HashMap();
  	  	mp.put("username","tom");
  	  	mp.put("password","123");
  	  	mp.put("age","28");
  	  	
  		request.setAttribute("map", mp);
  		
  		%>
  	  
  		<c:forEach items="${map}" var="m">
  			${m.key }---${m.value}<br/>
  		</c:forEach>
  	
  </body>
  
</html>
