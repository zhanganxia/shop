package cn.it.shop.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.util.HibernateSessionFactory;
/*
 * 目前Serviceyu Dao整合在一起的
 */
public class CategoryServiceImpl implements CategoryService {

	@Override//没有整合的情况
	public void save(Category category) {
		//hibernateTemplate.save(category);
		// 通过工具类获取session
		Session session=HibernateSessionFactory.getSession();
		try{
		//手动事务
		session.getTransaction().begin();
		//执行业务逻辑
		session.save(category);
		//手动提交
		session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	//Spring和hibernate整合后
	//有侵入性
	//private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	//当需要使用sessionFactory的时候Spring会将sessionFactory注入进来
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession(){
		//从当前线程获取session，如果没有创建一个新的session
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void update(Category category) {
		getSession().update(category);
		System.out.println("------");
		
		//Integer.parseInt("xyz");
		
	}

}
