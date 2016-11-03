package cn.it.shop.service;

import cn.it.shop.model.Category;

public interface CategoryService {

	public void save(Category category);//用来测试Hiibernate环境
	public void update(Category category);//用来测试Spring和Hibernate整合后
}
