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
@SuppressWarnings("unchecked")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	//查询热点类别
	public CategoryServiceImpl(){
		super();
	}
	
	@Override
	public List<Category> queryJoinAccount(String type,int page,int size) {
		String hql="FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE:type";
		return getSession().createQuery(hql)
		.setString("type", "%" +type+ "%")
		.setFirstResult((page-1)*size)
		.setMaxResults(size)
		.list();
	}

	@Override
	public Long getCount(String type) {
		String hql="SELECT count(c) FROM Category c WHERE c.type LIKE:type";
		return (Long)getSession().createQuery(hql)
		.setString("type", "%"+type+"%")
		.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql="DELETE FROM Category WHERE id in(" +ids+ ")";
		getSession().createQuery(hql)
		.executeUpdate();
		
	}
}
