<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head> 
   	<%@ include file="/public/head.jspf"%>
  </head>
  
  <body>
  		<a href="send_main_aindex.action"> 直接到后台UI版本</a>
  		<a href="send_main_index.action"> 直接到后台DIV版 </a>
  	   <a href="${shop}/category_update.action?id=2&type=gg&hot=false">ModelDriven测试</a>
	   <a href="${shop}/category_update.action?category.id=2&category.type=gg&category.hot=false">访问update SSH环境</a>
	   <a href="category_save.action">访问save，测试Spring与Struts环境</a>
	   <a href="account_query.action?login=admin&pass=admin***">account Action测试</a>
	   <a href="category_query.action">查询所有类别</a><br/>
	   <c:forEach items="${requestScope.categoryList}" var="category">
	   		${category.id}|${category.type}|${category.hot}<br/>
	   </c:forEach>
	   <hr/>
	   <c:forEach items="${sessionScope.categoryList}" var="category">
	   		${category.id}|${category.type}|${category.hot}<br/>
	   </c:forEach>
	    <hr/>
	   <c:forEach items="${applicationScope.categoryList}" var="category">
	   		${category.id}|${category.type}|${category.hot}<br/>
	   </c:forEach>
  </body>
</html>
