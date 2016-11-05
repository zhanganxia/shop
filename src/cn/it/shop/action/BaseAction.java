package cn.it.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{

	protected T model;
	@Resource
	protected AccountService accountService;
	@Resource
	protected CategoryService categoryService;
//	
//	public void  setCategoryService(CategoryService categoryService){
//		this.categoryService=categoryService;
//	}
//	public void setAccountService(AccountService accountService) {
//		System.out.println("accountService:"+accountService);
//		this.accountService = accountService;
//	}
	protected Map<String,Object> request;
	protected Map<String,Object> session;
	protected Map<String,Object> application;
	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
	@Override
	public T getModel() {//这里通过解析传进来的T来new一个对应的instance
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz=(Class)type.getActualTypeArguments()[0];
		try {
			model=(T)clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}
}
