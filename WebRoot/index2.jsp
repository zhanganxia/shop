<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
   	<%@ include file="/public/head.jspf"%>
  </head>
  <!-- 没有UI的 -->
  <body>
  		<table width="700" border="2" cellspacing="2" cellpadding="2">
  		<!-- 大循环 开始 -->
  		<c:forEach items="${applicationScope.bigList}" var="list">
  		<!-- 显示当前类别名称， list表示当前商品集合 -->
  			<tr>
  				<!-- 获取第一个商品的类别信息，第二，三，四个也可以，但是为安全起见选第一个 -->
  				<td colspan="4">${list[0].category.type}</td>
  			</tr>
  		<!-- 显示当前类别的商品信息 -->
  		<tr>
  			<td>
  				<table width="100%" border="0" cellspacing="0" cellpadding="0">
  					<tr>
  					<!-- 小循环开始 -->
  					<c:forEach items="${list}" var="product">
  						<td>
  							<!-- 显示具体的商品信息 -->
  							<table width="100%" border="0" cellspacing="0" cellpadding="0">
  								<tr>
						  			<td>
						  				<!-- 图片 -->
						  				<img src="${shop}/image/${product.pic}"/>
						  			</td>
						  		</tr>
						   		<tr>
						  			<td>
						  				商品名称：${product.name}
						  			</td>
						  		</tr>
						  		<tr>
						  			<td>
						  				价格：${product.price}
						  			</td>
						  		</tr>
  							</table>
  							<!-- 商品信息结束 -->
  						</td>
  						</c:forEach>
  					<!-- 小循环结束 -->
  					</tr>
  				</table>
  			</td>
  		</tr>
  		</c:forEach>
  		<!-- 大循环结束 -->
  		<tr>
  			<td>&nbsp;</td>
  		</tr>
   		<tr>
  			<td>&nbsp;</td>
  		</tr>
  		</table>
  </body>
</html>
