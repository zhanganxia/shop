<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
   <a href="${pageContext.request.contextPath}/category_update.action?category.id=2&category.type=gg&category.hot=false">访问update SSH环境</a>
   <a href="category_save.action">访问save，测试Spring与Struts环境</a>
  </body>
</html>
