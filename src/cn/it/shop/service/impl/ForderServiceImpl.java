package cn.it.shop.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements
		ForderService {

	@Override
	public BigDecimal cluTotal(Forder forder) {
		BigDecimal total=new BigDecimal(0.00);
		for(Sorder temp : forder.getSorderList()){
			//total +=temp.getNumber()*temp.getPrice();
			total=total.add(temp.getPrice().multiply(new BigDecimal(temp.getNumber())));
		}
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		String hql="UPDATE Forder f SET f.status.id=:sid where f.id=:id";
		getSession().createQuery(hql)
		.setInteger("sid", sid)
		.setInteger("id", id)
		.executeUpdate();
	}


}
