package cn.it.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
/*
 * 设置任务：run方法中用来加载首页商品信息数据,这是一个普通的javaBean,
 * 可以交给Spring来管理,
 * ProductTimerTask要在InitDataListener监听器中调用，监听器中有event（ApplicationContext）的环境
 */
@Component("productTimerTask")
public class ProductTimerTask extends TimerTask{

	@Resource
	private ProductService productService=null;
	@Resource
	private CategoryService categoryService=null;
	
	private ServletContext application=null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		List<List<Product>> bigList=new ArrayList<List<Product>>();
		for(Category category:categoryService.queryByHot(true)){
			bigList.add(productService.queryByCid(category.getId()));
		}
		application.setAttribute("bigList", bigList);
	}
/*	
 *测试守护线程和非守护线程的区别
 public static void main(String[] args) {
		new Timer(true).schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("-----run-----");
			}
		}, 0, 2000);
	}
	*/
}
