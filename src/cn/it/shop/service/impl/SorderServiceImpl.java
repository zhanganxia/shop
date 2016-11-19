package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;
@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave=false;
		Sorder sorder=productToSorder(product);
		//判断当前购物项是否重复，如果重复则添加数量即可
		for(Sorder old:forder.getSorderList()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//购物项有重复，添加数量即可
				old.setNumber(old.getNumber()+sorder.getNumber());
				isHave=true;
				break;
			}
		}
		//说明当前购物项在购物车中是不存在的，新添加即可
		if(!isHave){
			//建立购物项目与购物车之间的关联，此时forder，id为null,但是在入库的时候是先入库购物车，在入库购物项，那时forder就有主键了
			sorder.setForder(forder);
			forder.getSorderList().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder=new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder updateSorder(Sorder sorder,Forder forder) {
		for(Sorder temp:forder.getSorderList()){
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())){
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}




}
