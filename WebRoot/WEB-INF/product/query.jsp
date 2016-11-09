<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head> 
		<%@ include file="/public/head.jspf"%>
		<style type="text/css">
			body{
				margin:1px;
			}
			.searchbox {
			  margin:-3;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				$('#dg').datagrid({    
					//请求数据的URL地址
				    url:'product_queryJoinCategory.action',
				    queryParams:{name:''},
				    //指定id字段为标识字段，在删除更新的时候有用，如果配置此字段，在翻页的时候被选中的记录是不会丢失
				    idField:'id',
				    //width:250,
				   //斑马线效果
				    striped:true,
				    //数据显示在同行，默认为true
				    nowrap:true,
				    //自动适应列，如果设置此属性，则不会出现水平滚动条，在演示冻结列此参数不要设置
				    fitColumns:true,
				    //单行显示列：全选功能会失效
				    singleSelect:false,
				    //如果为true，则在DataGrid控件底部显示分页工具栏。
				    pagination:true,
				    pageSize:5,
				    pageList:[5,10,15,20],
				    toolbar: [{
						iconCls: 'icon-add',
						text:'添加商品',
						handler: function(){
							parent.$("#win").window({
							title:'添加商品',
							width:500,
							height:600,
							content:'<iframe src="send_product_save.action" frameboder="0" width="100%" height="100%">'
							});
							}
					},'-',{
						iconCls: 'icon-edit',
						text:'更新商品',
						handler: function(){
							alert("---自己实现--");
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除类别',
						handler: function(){
							alert("---自己实现--");
						}
					},'-',{
						text:"<input id='ss' name='search'/>"
					}],
				    
				    //同列属性，但是这些列将会被冻结在左侧。
				    frozenColumns:[[
				    	{field:'xyz',checkbox:true},
				    	{field:'id',title:'商品编号',width:100}
				    ]], 
				    //配置dg的列字段  field：列字段名称，与json的key捆绑title：列标签
				    columns:[[     
				        {field:'name',title:'商品名称',width:200},    
				        {field:'remark',title:'简单介绍',width:300}, 
				      {field:'category.type',title:'所属类别',width:100,
				      		formatter: function(value,row,index){
				      		if(row.category!=null&&row.category.type!=null){
				      			return row.category.type;
				      		}	
				        }
				      }  
				    ]]    
				});
				//把普通的文本框转化为搜索文本框
				$('#ss').searchbox({ 
					//触发查询事件
					searcher:function(value,name){
						//获取当前查询的关键字 
						//alert(value + "," + name); 
					$('#dg').datagrid('load',{type: value,});
					}, 
					prompt:'变形金刚' 
				}); 		
			});
		</script>
  </head>
  <body>
	<table id="dg"></table>
  </body>
</html>
