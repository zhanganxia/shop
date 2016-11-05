<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head> 
		<%@ include file="/public/head.jspf"%>
		<script type="text/javascript">
			$(function(){
				$('#dg').datagrid({    
					//请求数据的URL地址
				    url:'datagrid_data1.json',
				    width:250,
				    //同列属性，但是这些列将会被冻结在左侧。
				    frozenColumns:[[
				    	{field:'code',title:'Code',width:100},  
				    ]], 
				    //配置dg的列字段  field：列字段名称，与json的key捆绑title：列标签
				    columns:[[     
				        {field:'productname',title:'产品的名称',width:100},    
				        {field:'unitcost',title:'Price',width:100,align:'right'}    
				    ]]    
				});		
			});

		</script>
  </head>
  <body>
	<table id="dg"></table>
  </body>
</html>
