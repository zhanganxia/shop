<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head> 
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript">
		//扩展的函数，接受json格式，此方法支持jquery类直接调用，类函数
		$.extend({
			max:function(a,b){
				return a>b?a:b;
			},
			min:function(a,b){
				return a<b?a:b;
			}
		});
		alert($.max(2.3));//jQuery 类的函数
		alert($("#abc").min(2.3));////jQuery 对象的函数
	
		//支持jQuery对象来用
		$.fn.extend({
		
		});
		//多数情况下用此方式，jQuery 对象函数
		$.extend($.fn,{
		
		});		
	</script>
  </head>
  <body>
	<div id="abc"></div>
		
  </body>
</html>
