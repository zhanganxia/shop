<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  	   <a href="${pageContext.request.contextPath}/category_update.action?id=2&type=gg&hot=false">ModelDriven测试</a>
	   <a href="${pageContext.request.contextPath}/category_update.action?category.id=2&category.type=gg&category.hot=false">访问update SSH环境</a>
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
