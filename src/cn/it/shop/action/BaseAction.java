package cn.it.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*Struts执行流程：先创建Action，在调用拦截器，拦截器访问成功在调用Action的方法（以文件上传为例，文件注入到Action的成员变量中）
 * Action没有创建，文件上传是不能做的。
 * 
 *在项目启动的时候Struts的过滤器，已经把想要的内置对象，和内置对象相应的Map存储到了ActionContext和值栈中
 *如果实现了相应的***Aware接口，就会从ActionContext中获取相应的Map进行传入，实现的拦截器为：servletConfig

	servletConfig:有如下代码：判断当前实现了什么借口，则会注入相应的对象
		if(action instanceof ApplicationAware){
				((ApplicationAware)action).setApplication(context.getApplication());
			}
		if(action instanceof SessionAware){
				((SessionAware)action).setSession(context.getSession());
			}
		if(action instanceof RequestAware){
			((RequestAware)action).setRequest((Map) context.get("request"));
			}
 *
 */
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{

	protected T model;
	

//	protected AccountService accountService;
//	
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
