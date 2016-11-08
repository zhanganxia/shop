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
			//iframe中的dg对象
			var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
			//对管理员的下拉列表框进行远程加载
			$('#cc').combobox({    
			    url:'account_query.action',    
			    valueField:'id',    
			    textField:'login',
			    panelHeight:'auto',
			    panelWidth:120,
			    Width:120,
			    editable:false
			});
			//1.完成数据的回显
			var rows=dg.datagrid("getSelections");
			$('#ff').form('load',{
				id:rows[0].id,
				type:rows[0].type,
				hot:rows[0].hot,
				'account.id':rows[0].account.id
			});

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
						url:'category_update.action',
						success: function(){
							// 如果提交成功则关闭当前窗体
							parent.$("#win").window("close");
							 dg.datagrid("reload");
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
        <label for="account">所属管理员：</label>   
       <!--  基于Html代码的方式
       <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
		    <option value="aa">aitem1</option>   
		    <option>bitem2</option>   
		    <option>bitem3</option>   
		    <option>ditem4</option>   
		    <option>eitem5</option>   
		</select>   -->
		<!-- 远程加载管理员的数据 -->
		<input id="cc" name="account.id"> 
		
    </div>   
    <div>
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类别</a>
    <input type="hidden" name="id"/>
    </div>      
</form>
		
  </body>
</html>
