package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * OGNL表达式语法：通过根对象，从上向下查找，如果名称正确则查找成功，赋值后返回，否则继续向下查找，直到找到为止
 * OgnlValueStack:root是栈结构，可以实现后进先出
 * 拦截器：modelDriven
 * ModelDriven:此接口必须要实现getModel()方法，此方法会把返回的对象，压到栈顶中
 */
public class CategoryAction extends BaseAction<Category>{
	
	public String update(){
		System.out.println(ActionContext.getContext().getValueStack().getRoot());
		System.out.println("-- update--");
		System.out.println(model);//直接使用model
		return "index";
	}
	public String save(){
		System.out.println("-- save--");
		return "index";
	}
	public String query(){
		request.put("categoryList", categoryService.query());
		session.put("categoryList", categoryService.query());
		application.put("categoryList", categoryService.query());
		return "index";
	}

}
