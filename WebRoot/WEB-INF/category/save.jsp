<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head> 
		<%@ include file="/public/head.jspf"%>
		<style type="text/css">
		form div{
			margin:5px;
		}
		</style>
		<script type="text/javascript">
			$(function(){
				$("input[name=type]").validatebox({
				required:true,
				missingMessage:'请输入类别名称'
				});
			//窗体弹出默认时禁用验证
			$("#ff").form("disableValidation");
			//注册button的事件
			$("#btn").click(function(){
				//开启验证
			$("#ff").form("enableValidation");
			//如果验证成功，则提交数据
			if($("#ff").form("validate")){
				//调用submit方法，提交数据
				$('#ff').form('submit', {
					url:'category_save.action',
					success: function(){
						// 如果提交成功则关闭当前窗体
						parent.$("#win").window("close");
						//刷新页面，获取aindex--->ifream-->dg  dom--->jquery--->easyui越往上兼容性问题越多
						//datagrid与谷歌浏览器不兼容，一般向下强转
						//var dg=parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("reload");
						var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
							}
						});
					}
				});
			});
		</script>
  </head>
  <body>
	<form id="ff" method="post">   
    <div>   
        <label for="type">类别名称：</label>   
        <input type="text" name="type"  />   
    </div>   
    <div>   
        <label for="hot">热点：</label>   
		<input type="radio" name="hot" value="true"/>
		<label for="hot">热点</label>
		 <input type="radio" name="hot" value="false" checked="checked"/>
		 <label for="hot">非热点</label>
    </div>
    <div>
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类别</a>
    </div>      
</form>
		
  </body>
</html>
