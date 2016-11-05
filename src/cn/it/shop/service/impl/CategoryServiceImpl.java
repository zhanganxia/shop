package cn.it.shop.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.util.HibernateSessionFactory;
/*
 * 模块自身的业务逻辑
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	//查询热点类别
	public CategoryServiceImpl(){
		super();
	}
//	public static void main(String[] args) {
//		new CategoryServiceImpl();
//	}
}
