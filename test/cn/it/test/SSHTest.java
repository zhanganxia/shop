package cn.it.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)//支持注解测试，在Spring-test中
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	@Resource
	private Date date;
	
	@Resource
	private CategoryService categoryService;
	
	@Test//测试SpringIOC的开发环境
	public void SpringIoc(){
		System.out.println(date);	
	}
	@Test//测试Hibernate的开发环境，因为没有整合，也可以直接new
	public void hibernate(){
		CategoryService categoryService=new CategoryServiceImpl();
		categoryService.save(new Category("男士休闲",true));
	}
	@Test//测试Hibernate和Spring整合后
	public void hibernateAndSpring(){
		categoryService.update(new Category(1, "女士休闲",true));//categoryService通过Spring从上面注入进来
	}
}
