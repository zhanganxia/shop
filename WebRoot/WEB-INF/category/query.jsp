<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head> 
		<%@ include file="/public/head.jspf"%>
		<script type="text/javascript">
			$(function(){
				$('#dg').datagrid({    
					//请求数据的URL地址
				    url:'category_queryJoinAccount.action',
				    queryParams:{type:''},
				    //width:250,
				   //斑马线效果
				    striped:true,
				    //数据显示在同行，默认为true
				    nowrap:true,
				    //自动适应列，如果设置此属性，则不会出现水平滚动条，在演示冻结列此参数不要设置
				    fitColumns:true,
				    //单行显示列：全选功能会失效
				    singleSelect:true,
				    //如果为true，则在DataGrid控件底部显示分页工具栏。
				    pagination:true,
				   /*
				    rowStyler:function(index,row){
				    		//返回的字符默认交给style
							if(index%2==0){
							//return 'background-color:#6293BB;color:#ff0000;';
							return 'background-color:#ff0000;';
							}else{
							return 'background-color:#00ff00;';
							
							}
						},*/
				    
				    //同列属性，但是这些列将会被冻结在左侧。
				    frozenColumns:[[
				    	//如果为true，则显示复选框。该复选框列固定宽度,注意此处field必须捆绑一个字段，不能为空
				    	{field:'xyz',checkbox:true},
				    	{field:'code',title:'编号',width:100}  
				    ]], 
				    //配置dg的列字段  field：列字段名称，与json的key捆绑title：列标签
				    columns:[[     
				        {field:'type',title:'类别名称',width:100,
				        //用来格式化当前列的值，返回的是最终的数据。
				        	formatter: function(value,row,index){
				        		return "<span title=" + value + ">" + value + "</span>";
				        	}
				        },    
				        {field:'hot',title:'热点',width:100,align:'right',
				        /*设置当前单元格的样式，返回的字符串直接交给style属性
				        styler: function(value,row,index){
				        	console.info("val:"+value+",row:"+row+",index:"+index);
							if (value < 60){
								return 'color:red;';
								}
							}*/
				        },
				          {field:'account.login',title:'所属管理员',width:100}    
				    ]]    
				});		
			});

		</script>
  </head>
  <body>
	<table id="dg"></table>
  </body>
</html>
