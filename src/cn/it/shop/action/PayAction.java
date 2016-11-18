package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.BackData;
import cn.it.shop.model.Forder;
import cn.it.shop.model.SendData;
import cn.it.shop.model.User;
/*
 Struts处理流程：获取请求后，先创建Action代理，在创建代理的时候顺便创建了 Action，执行拦截18个拦截器
 拦截器执行成功在调用Action的方法。
 
 action的方法执行完毕后，在返回调用拦截器
 
 创建Action---->servletConfig--->modelDriven
 */
@Controller
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware{

	private Map<String,String[]> parameters;
	
	@Override
	public Object getModel() {
		if(parameters.get("pd_FrpId")!=null){
			model=new SendData();
		}else{
			model=new BackData();
		}
		return model;
	}
	
	@Override
	public void setParameters(Map<String, String[]> arg0) {
		this.parameters=parameters;
		
	}
	public String goBank(){
		SendData sendData=(SendData)model;
		//1.补全参数P2 p3 pd Pa需要从session中获取
		Forder forder=(Forder)session.get("oldForder");
		User user=(User)session.get("user");
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getEmail()+","+user.getPhone());
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储至request域中
		payService.saveDataToRequest(request, sendData);
		//5.跳转到支付页面
		return "pay";
	}

	public void backBank(){
		BackData backData=(BackData)model;
		System.out.println(backData);
		boolean isOk=payService.checkBackData(backData);
		if(isOk){
			//1:更新订单状态
			forderService.updateStatusById(2017021892,2);
			//2.根据user的邮箱地址，发送邮箱地址，发送邮件
			//3.发送手机短信
			System.out.println("---success----");
		}else{
			System.out.println("----fail------");
			
		}
	}
}
