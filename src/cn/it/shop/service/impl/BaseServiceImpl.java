package cn.it.shop.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.service.BaseService;
/*
 * 公共模块的抽取
 */
@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {

	private Class clazz;//clazz中存储了当前操作的类型
	
	public BaseServiceImpl(){
		System.out.println("this代表的是当前调用构造方法的对象："+this);
		System.out.println("获取当前this对象的父类信息："+this.getClass().getSuperclass());
		System.out.println("获取当前this对象的父类信息(包括泛型信息)："+this.getClass().getGenericSuperclass());
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class)type.getActualTypeArguments()[0];
	}
	@Resource //没有指定名称默认的是与id捆绑，在此调用注解，会默认调用set方法
	private SessionFactory sessionFactory;
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	protected Session getSession(){
		//从当前线程获取session，如果没有创建一个新的session
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T t) {
		getSession().save(t);
	}
	@Override
	public void update(T t) {
		getSession().update(t);
	}
	@Override
	public void delete(int id) {
		//此方法删除有缺陷，删除的时候得先查询，如果数据为空会报错
//		Object object=getSession().get(clazz, id);
//		if(object!=null){
//			getSession().delete(object);
//		}
		System.out.println(clazz.getSimpleName());
		String hql="DELETE "+clazz.getSimpleName()+" WHERE id=:id";
		getSession().createQuery(hql)
		.setInteger("id", id)
		.executeUpdate();
	}
	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}
	@Override
	public List<T> query() {
		String hql="FROM "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}
}
