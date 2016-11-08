<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head> 
		<%@ include file="/public/head.jspf"%>
		<style type="text/css">
			body{
				margin:1px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				$('#dg').datagrid({    
					//请求数据的URL地址
				    url:'category_queryJoinAccount.action',
				    queryParams:{type:''},
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
						text:'添加类别',
						handler: function(){
							alert('--自己实现--');
							}
					},'-',{
						iconCls: 'icon-edit',
						text:'更新类别',
						handler: function(){
							alert('跟新类别');
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除类别',
						handler: function(){
							//1.判断是否有选中行记录
						var rows=$("#dg").datagrid("getSelections");
						//rows返回被选中的行，没有任何行被选中，则返回空数组
						if(rows.length==0){
							//弹出提示信息
							$.messager.show({
								title:'错误提示',
								msg:'至少选择一条记录',
								timeout:2000,
								showType:'slide'
							});
						}else{
							//提示是否确认删除执行删除的逻辑
							$.messager.confirm('删除确认对话框', '是否要选中删除的记录！', function(r){
								if (r){
								  //1:获取被选中的记录，然后从记录中获取相应的id
								  var ids="";
								  for(var i=0;i<rows.length;i++){
								  	ids +=rows[i].id+",";
								  }
								  //2:拼接Id的值，然后发送后台1,2,3,4
								  ids=ids.substring(0,ids.lastIndexOf(","));
								  //3.发送ajax请求
								 
								  $.post("category_deleteByIds.action",{ids:ids},function(result){
								  		if(result == "true"){
								  		//重新刷新当前页
								  		var rows=$("#dg").datagrid("reload");
								  		}else{
								  		$.messager.show({
											title:'删除异常',
											msg:'删除失败，请检查操作！',
											timeout:2000,
											showType:'slide'
										});
								  		}
								  },"text");
									}
								});	
							}
						}
					},'-',{
						text:"<input id='ss' name='search'/>"
					}],
				    
				    //同列属性，但是这些列将会被冻结在左侧。
				    frozenColumns:[[
				    	//如果为true，则显示复选框。该复选框列固定宽度,注意此处field必须捆绑一个字段，不能为空
				    	{field:'xyz',checkbox:true},
				    	{field:'id',title:'编号',width:100, 
				    	formatter: function(value,row,index){
				        return "<span title=" + value + ">" + value + "</span>";
				        	} 
				        },
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
				        formatter: function(value,row,index){
				        	if(value){
				        		return "<input type='checkbox' checked='checked' disabled='disabled'/>";
				        		}else{
				        		return "<input type='checkbox' disabled='false'/>";
				        		}
				        	}
				        }, 
				      {field:'account.login',title:'所属管理员',width:100,
				      		formatter: function(value,row,index){
				      		if(row.account!=null&&row.account.login!=null){
				      			return row.account.login;
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
