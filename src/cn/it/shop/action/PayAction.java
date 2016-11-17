package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.SendData;

@Controller
@Scope("prototype")
public class PayAction extends BaseAction<SendData> {

	public String goBank(){
		//1.补全参数
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储至request域中
		//5.跳转到支付页面
		return "";
	}
}
