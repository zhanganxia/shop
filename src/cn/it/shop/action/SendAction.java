package cn.it.shop.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class SendAction extends ActionSupport{

	public SendAction(){
		System.out.println("----sendAction-----");
	}
	
	public String execute(){
		return "send";
	}
}
