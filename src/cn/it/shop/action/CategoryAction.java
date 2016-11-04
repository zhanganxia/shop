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
public class CategoryAction extends BaseAction implements ModelDriven<Category>{
	
	private Category category;
	@Override
	public Category getModel() {
		category =new Category();
		return category;
	}
	private CategoryService categoryService;
	
	public void  setCategoryService(CategoryService categoryService){
		this.categoryService=categoryService;
	}
//	private Integer id;
	
//	private Integer id1;
//	public void setId1(Integer id1) {
//		this.id1 = id1;
//	}
	
	
	public String update(){
		//System.out.println(ActionContext.getContext().getValueStack().getRoot());
		System.out.println("-- update--");
		categoryService.update(category);
		return "index";
		//值栈
		//ActionContext.getContext().getValueStack().push();
	//	System.out.println(id);//不可对Id赋值，因为开始找到id就返回了
	//	System.out.println(id1);//id1可以赋值
		//categoryService.update(category);//新加一条语句，来跟新数据库
		
	}
	public String save(){
		System.out.println("-- save--");
		return "index";
	}
	public String query(){
		//显示值栈中的root对象
		System.out.println(ActionContext.getContext().getValueStack().getRoot());
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
