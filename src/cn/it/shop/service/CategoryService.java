package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Category;
//CategoryService接口继承BaseService接口
public interface CategoryService extends BaseService<Category>{

	//查询类别信息，级联管理员
	public List<Category> queryJoinAccount(String type,int page,int size);
	//根据关键字查询总记录数
	public Long getCount(String type);
	//根据Id删除多条记录
	public void deleteByIds(String ids);
	//根据boolean查询热点类别
	public List<Category>  queryByHot(boolean hot);
	
	
}
