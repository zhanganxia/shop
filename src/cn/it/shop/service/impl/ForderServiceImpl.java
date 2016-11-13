package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements
		ForderService {

	@Override
	public double cluTotal(Forder forder) {
		double total=0.0;
		for(Sorder temp:forder.getSorderList()){
			total +=temp.getNumber()*temp.getPrice();
		}
		return total;
	}


}
