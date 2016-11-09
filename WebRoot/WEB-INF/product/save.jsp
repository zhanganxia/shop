<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的JSP片段 -->
	<%@ include file="/public/head.jspf"%>
	<style type="text/css">
		form div{
			margin: 10px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
		//自定义验证方法，向validatebox.defaults.rules中注册新函数
			$.extend($.fn.validatebox.defaults.rules, {  
				//函数的名称：函数的实现体  （又是一个json对象，里面包括函数的实现，和错误消息设置）
			    format: {
			    	//函数实现，如果返回为false,则验证失败    
			        validator: function(value,param){  
			        	//console.info(value+","+param.length);  
			        	//获取当前文件的后缀名
			        	var ext=value.substring(value.lastIndexOf('.')+1);
			        	//获取支持的文件后缀名，然后比较即可
			        	var arr=param[0].split(",");
			        	for(var i=0;i<arr.length;i++){
			        		if(ext==arr[i])
			        		return true;
			        	}
			            return false;    
			        }, 
			        //错误消息   
			        message: '文件必须为：{0}' 
			    }    
			});
		
			//对所属类别下拉列表框进行远程加载
			$('#cc').combobox({    
			    url:'category_query.action',    
			    valueField:'id',    
			    textField:'type',
			    panelHeight:'auto',
			    panelWidth:120,
			    Width:120,
			    editable:false,
				required:true,
				missingMessage:'请选择所属类别'
			});		
		
			$("input[name=name]").validatebox({
				required:true,
				missingMessage:'请输入商品名称'
			});	
			$("input[name=price]").numberbox({
				required:true,
				missingMessage:'请输入商品价格',
				min:0,    
    			precision:2,//保留两位小数
    			prefix:'$'  //前缀
			});	
			$("input[name=upload]").validatebox({
				required:true,
				missingMessage:'请上传商品图片',
				//设置自定义方法
				validType:"format['gif,jpg,jpng,png']"
			});	
			//当文件域内容发生变化时，则调用验证方法（默认是单击提交时调用验证）
			$("input[name=upload]").change(function(){
				//验证文本框的内容是否有效
				$(this).validatebox("validate");
			});
			$("textarea[name=remark]").validatebox({
				required:true,
				missingMessage:'请输入商品简单描述'
			});
		});
	</script>
</head>

<body>
<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称:</label> <input type="text" name="name" />
	</div>
	<div>
		<label>商品价格:</label> <input type="text" name="price" />
	</div>
	<div>
		<label>图片上传:</label> <input type="file" name="upload" />
	</div>
	<div>
		<label>所属类别：</label> 
		<input id="cc" name="category.id" />
	</div>
	<div>
		<label>加入推荐:</label> 
		推荐:<input type="radio" name="commend"
			checked="checked" value="true" />  
		不推荐:<input type="radio"
			name="commend" value="false" /> 
	</div>
	<div>
		<label>是否有效:</label>
		上架:<input type="radio" name="open" checked="checked"value="true" />
		下架:<input type="radio" name="open" value="false" />
				
	</div>
	<div>
		<label>简单描述:</label>
		<textarea name="remark" cols="40" rows="4"></textarea>
	</div>
	<div>
		<label>详细描述:</label>
		<textarea name="xremark" cols="40" rows="8"></textarea>
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>
</body>
</html>
