package cn.it.shop.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String queryJoinCategory(){
		pageMap=new HashMap<String, Object>();
		System.out.println("name:" + model.getName());
		List<Product> productList=productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList);
		//根据关键字查询总的记录数。
		pageMap.put("total", productService.getCount(model.getName()));
		return "jsonMap";
	}

	public void save(){
		System.out.println(model);
	}
}
