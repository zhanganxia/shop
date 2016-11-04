package cn.it.shop.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Account;
import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
@RunWith(SpringJUnit4ClassRunner.class)//支持注解测试，在Spring-test中
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class AccountServiceImplTest {

	@Resource
	private AccountService accountService;
	@Test
	public void testSave() {
		accountService.save(new Account("admin","大强","admin***"));
	}
}
