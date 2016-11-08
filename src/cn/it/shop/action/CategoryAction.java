package cn.it.shop.action;

import java.util.HashMap;
import java.util.List;
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

	public String queryJoinAccount(){
		//用来存储分页的数据
		pageMap=new HashMap<String, Object>();
		System.out.println("type:" + model.getType());
		//根据关键字和分页的参数查询相应的数据
		List<Category> categoryList=categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		//根据关键字查询总的记录数。
		pageMap.put("total", categoryService.getCount(model.getType()));
	
		return "jsonMap";
	}
}
