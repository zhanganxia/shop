package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;
@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	
	//下面实现的是把model中的东西给session，如果model中直接拿的是session中的forder信息，就不需要下面的步骤了
	//重写getModel方法
	@Override
	public Forder getModel() {
		model=(Forder)session.get("forder");
		return model;
	}

	//实现购物车（订单）与购物项（订单项）级联入库功能
	public String save(){
		//把session中的购物项，交给当前的model对象
		/*		Forder forder=(Forder)session.get("forder");
		model.setSorderSet(forder.getSorderSet());
		//把model中的东西给session
		forder.setAddress(model.getAddress());
		forder.setName(model.getName());
		forder.setPhone(model.getPhone());
		forder.setRemark(model.getRemark());
		forder.setUser((User)session.get("user"));
		forder.setStatus(new Status(1));
		forder.setPost(model.getPost());
		//级联入库(需要在xml中配置),需要sorder关联forder，在SorderServiceImpl业务逻辑了类中
		//追加sorder.setForder(forder);
		forderService.save(forder);*/
		model.setUser((User)session.get("user"));
		model.setStatus(new Status(1));
		forderService.save(model);
		return "bank";
	}
}
