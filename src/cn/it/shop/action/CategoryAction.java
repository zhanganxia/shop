package cn.it.shop.action;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
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
}
