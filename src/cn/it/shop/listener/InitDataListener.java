package cn.it.shop.listener;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.service.ProductService;

/*
 * 用于项目启动的时候数据初始化
 */
public class InitDataListener implements ServletContextListener {

	private ProductService productService=null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// 1.获取业务逻辑类查询商品信息

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//解决方案一：注入到Spring中，不可取监听器是web层的组件，Spring是访问逻辑层和数据访问层的依赖，Spring不能实例化监	听器
		//解决方案二:不可取，会把Spring配置文件加载两次
	/*	ApplicationContext context=new ClassPathXmlApplicationContext(
				"applicationContext-*.xml");
		productService=(ProductService)context.getBean("productService");
		System.out.println(productService);
*/
		//2.项目在启动的时候把Spring配置文件通过监听器加载，存入了ServletContext中
		//我们获取即可
	//WebApplicationContextUtils:该工具类可以到ServletContext中获取配置文件
		
		//解决方案三：直接到ServletContext中获取Spring配置文件,此方案的key不容易记住
/*	ApplicationContext context=(ApplicationContext)event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	productService=(ProductService)context.getBean("productService");
	System.out.println("productService:"+productService);*/
	
	//解决方案四：通过工具类加载即可
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productService=(ProductService)context.getBean("productService");
		System.out.println("productService:"+productService);
	}
}
