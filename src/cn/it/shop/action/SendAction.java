package cn.it.shop.action;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 此Action用来完成web-info中jsp与jsp请求转发功能，此Action不处理任何的逻辑
 */
public class SendAction extends ActionSupport{

	public SendAction(){
		System.out.println("----sendAction-----");
	}
	
	public String execute(){
		return "send";
	}
}
