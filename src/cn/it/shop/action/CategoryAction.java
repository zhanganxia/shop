package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends BaseAction{
	public CategoryAction(){
		System.out.println("---CategoryAction----");
	}
	private Category category;//设置一个私有成员变量接收url带过来的参数，注意写好get&&set方法
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	private CategoryService categoryService;//设置CategoryService是为了很直观的看出与Spring整合前后的不同
	public void  setCategoryService(CategoryService categoryService){
		this.categoryService=categoryService;
	}
	public String update(){
		//值栈
		//ActionContext.getContext().getValueStack().push();
		System.out.println("-- update--");
		System.out.println(categoryService);//整合前后输出不同
		categoryService.update(category);//新加一条语句，来跟新数据库
		return "index";
	}
	public String save(){
		System.out.println("-- save--");
		System.out.println(categoryService);
		return "index";
	}
	public String query(){
		//方案一,采用相应的map取代原来的内置对象，这样与jsp没有依赖，但是代码量较大
//		ActionContext.getContext().put("categoryList", categoryService.query());//放到ruquest域中
//		ActionContext.getContext().getSession().put("categoryList", categoryService.query());//放到session域中
//		ActionContext.getContext().getApplication().put("categoryList", categoryService.query());//放到Application域中
		
		//方案二：实现相应的接口(RequestAware,SessionAware,ApplicationAware).让相应的map注入
		//但是如果接口写在子类，代码量也会比较大，因此创建BaseAction
		System.out.println("方案三：使用BaseAction");
		request.put("categoryList", categoryService.query());
		session.put("categoryList", categoryService.query());
		application.put("categoryList", categoryService.query());
		return "index";
	}
	
}
