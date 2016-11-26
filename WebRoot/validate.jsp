<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jquery validate验证</title>
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript">
  	$(function(){
  		//让当前表单调用validate方法，实现表单验证功能
  		$("#ff").validate({
  			debug:true,//测试模式，即使验证成功，也不会跳转到目标页面
  			rules:{		//配置验证规则key就是被验证的DOM对象，value：调用的验证的方法
  				sname:{
  					required:true, //如果验证方法不需要参数，则配置为true
  				},
  				spass:{
  					required:true,
  					rangelength:[6,12]
  				},
  				spass2:{
  					required:true,
  					equalTo:'#spass'
  				},
  				slike:{
  					required:true
  				},
  				semail:{
  					required:true,
  					email:true
  				},
  				image:{
  					required:true,
  					accept:'gif|jpe?g|png'
  				}
  			} 
  		});
  	});
  	</script>
  	</head>
  <body>
  	<ul>
  		<li>基本验证方法的使用</li>
  		<li>209行，有缺省的验证配置</li>
  	</ul>
    <form id="ff" action="http://www.hao123.com" method="post">
    	姓名：<input type="text" name="sname"/><br/>
    	密码：<input type="text" name="spass"/><br>
    	确认密码：<input type="text" name="spass2"/>
   		<br/>
   		爱好：
   		上网：<input type="checkbox" name="slike" value="上网"/>
   		睡觉：<input type="checkbox" name="slike" value="睡觉"/>
   		旅游：<input type="checkbox" name="slike" value="旅游"/>
   		<br/>
   		邮箱：<input type="text" name="semail"/><br/>
   		头像：<input type="file" name="image"><br/>
   		
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
