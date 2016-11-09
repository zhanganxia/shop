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

	public void save() throws IOException{
		//获取文件后缀名,FilenameUtils是一个工具类，代替SubString获得文件后缀名
		String ext=FilenameUtils.getExtension(getFileImage().getFilename());
		
		//实现文件上传的功能，然后把生成唯一UUID文件名交给pic，然后商品数据入库
		FileUtil.copyFile(getFileImage().getFile(),new File("c:/"+UUID.randomUUID().toString()+"."+ext));
		
		System.out.println(model);
	}
}
