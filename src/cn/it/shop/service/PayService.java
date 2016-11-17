package cn.it.shop.service;

import java.util.Map;

import cn.it.shop.model.SendData;

public interface PayService {

	// 把加密后的信息存储到requestMap中
	//@Override
	public abstract Map<String, Object> saveDataToRequest(
			Map<String, Object> request, SendData sendData);

}