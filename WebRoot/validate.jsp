<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jquery validate验证</title>
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript">
  	$(function(){
  		//自定义方法，完成手机号码的验证
  		//addMethod(name,method,message);
  		//name：自定义方法的名称，method:函数体，message:错误消息
  		$.validator.addMethod("phone",function(value,element,param){
  			//function(value,element,param)
  			//value:被验证的值，element:当前验证的dom对象，param:参数，如果有多个则是数组
  			//alert(value+","+$(element).val()+","+param[0]+","+param[1]);
  			return new RegExp(/^1[3568]\d{9}$/).test(value);//检测value
  			
  			
  		},"手机号码不正确");
  		//
  		//让当前表单调用validate方法，实现表单验证功能
  		$("#ff").validate({
  			debug:true,//测试模式，即使验证成功，也不会跳转到目标页面
  			rules:{		//配置验证规则key就是被验证的DOM对象，value：调用的验证的方法
  				sname:{
  					required:true//如果验证方法不需要参数，则配置为true
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
  				phone:{
  					phone:[1,2]
  				}
  			}
  		});
  	});
  				//accept：输入拥有合法后缀名的字符串（上传文件的后缀）
  				//在此validate的验证文件中并没有这一个验证，在此不做演示
  				/* image:{
  					required:true,
  					accept:'gif|jpe?g|png'
  				} */
  			/* ,
  			messages:{
  				sname:{
  					required:"用户名必填"
  				},
  				spass:{
  					required:"密码必填",
  					rangelength:$.format("字段的长度必须为：{0},{1}之间")
  				} ,
  				spass2:{
  					required:"确认密码必填",
  					equalTo:"密码必须一致"
  				},
  				slike:{
  					required:"请选择爱好"
  				},
  				semail:{
  					email:"请输入正确的email格式"
  				} 
  			}*/

  	</script>
  	</head>
  <body>
  	<ul>
  		<li>实现错误消息本地化</li>
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
   		手机号码：<input type="text" name="phone"/>
   		<!-- 头像：<input type="file" name="image"><br/> -->
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
