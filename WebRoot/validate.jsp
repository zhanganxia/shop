<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jquery validate验证</title>
	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/jquery.validate.js"></script>
	<script type="text/javascript">
  	$(function(){
  		//让当前表单调用validate方法，实现表单验证功能
  		$("#ff").validate({
  			debug:false //测试模式，即使验证成功，也不会跳转到目标页面
  		});
  	});
  	</script>
  	</head>
  <body>
  	<ul>
  		<li>搭建了validate的开发环境</li>
  	</ul>
    <form id="ff" action="http://www.hao123.com" method="post">
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
