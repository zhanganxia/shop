package cn.it.shop.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
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
		String pic=fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		System.out.println(pic);
		//商品信息入库
		productService.save(model);
	}
	
	public String get(){
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
}
