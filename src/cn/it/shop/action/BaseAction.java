package cn.it.shop.action;

import java.io.InputStream;
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
	//获取要删除的ids数组
	protected String ids;
	
	protected Integer page;
	
	protected Integer rows;
	
	protected Map<String,Object> pageMap=null;
	
	protected InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public Map<String, Object> getPageMap() {
		return pageMap;
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
	
	@Resource
	protected AccountService accountService;
	@Resource
	protected CategoryService categoryService;

	protected Map<String,Object> request;
	protected Map<String,Object> session;
	protected Map<String,Object> application;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
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
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
}
