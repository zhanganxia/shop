<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
	<%@ include file="/public/head.jspf"%>
  </head>
  <body>
  	<div>
		<c:forEach items="${applicationScope.bankList}" var="bankImage"> 
			<span>
				<img src="${shop}/image/bank/${bankImage}" />
			</span>
		</c:forEach>
	</div>	
  </body>
</html>
