package cn.it.shop.service.impl;

import org.springframework.beans.factory.annotation.Value;

import cn.it.shop.model.SendData;

public class PayServiceImpl {
//密钥
	@Value("#{prop.key}")
	private String key;
	//商户编号（不是订单号）
	@Value("#{prop.p1_MerId}")
	private String p1_MerId;
	//支付成功的地址
	@Value("#{prop.p8_Url}")
	private String p8_Url;

	// 补全SendData的数据, P2 p3 pd Pa 是前台注入
	private SendData finishSendData(SendData sendData) {
			sendData.setP0_Cmd("Buy");
			sendData.setP1_MerId(p1_MerId);
			sendData.setP4_Cur("CNY");
			sendData.setP5_Pid("");
			sendData.setP6_Pcat("");
			sendData.setP7_Pdesc("");
			sendData.setP8_Url(p8_Url);
			sendData.setP9_SAF("0");
			sendData.setPr_NeedResponse("0");
			return sendData;
		}
}
