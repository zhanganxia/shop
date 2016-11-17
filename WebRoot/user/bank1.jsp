<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
	<%@ include file="/public/head.jspf"%>
  </head>
  <body>
  	<div style="width: 700px;">
		<c:forEach items="${applicationScope.bankList}" var="bankImage"> 
			<span>
				<input type="radio" name="" value="${fn:substring(bankImage, 0, fn:indexOf(bankImage,'.'))}" />
				 
				<img src="${shop}/image/bank/${bankImage}" />
			</span>
		</c:forEach>
	</div>	
  </body>
</html>
