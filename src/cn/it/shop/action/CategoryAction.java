package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
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
