package com.sven.util.wechat;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sven.payconfig.AlipayConfig;
import com.sven.payconfig.WechatConfig;

/*import org.apache.log4j.Logger;*/

import com.alibaba.fastjson.JSONObject;

/**
 * 支付帮助类, 存放一些支付的帮助方法
 * @author sven
 *
 */
public class PayHelper 
{
	/*private static Logger log = Logger.getLogger(PayHelper.class);*/
	
	/**
	 * 生成微信支付url
	 * @param orderID 订单id
	 * @return  string类型
	 */
	public static String genc_wxpay_direct_pay_url(Long orderID)
	{
		return "/front/wxpay/" + orderID;
	}
	/**
	 * 生成微信送礼支付url
	
	public static String genc_wxpay_send_pay_url(Long orderID){
		return "/front/gifts/distribute?orderId="+orderID;
	}
	 */
	/**
	 * 生成微信支付找人代付url
	 * @param orderID
	 * @return
	 */
	public static String genc_wxpay_replace_pay_url(Long orderID)
	{
		return "/front/wxpay/wxReplace_pay/" + orderID;
	}
	
	/**
	 * 生成支付宝即时到账支付url
	 * @param orderID
	 * @return
	 */
	public static String genc_alipay_direct_pay_url(Long orderID)
	{
		return "/front/alipay/direct_pay?orderID=" + orderID;
	}
	
	/**
	 * 分转元
	 * @param penny
	 * @return
	 */
	public static String penny2yuan(long penny)
	{
		BigDecimal bd = new BigDecimal(penny);
		return bd.divide(new BigDecimal(100) , 2, BigDecimal.ROUND_HALF_UP).toString();
	}
	
	/**
	 * 获取默认的微信支付配置 
	 * @return
	 */
	public static JSONObject getDefaultWechatPayConfig() 
	{
		JSONObject payConfig = new JSONObject();
		payConfig.put("appid", WechatConfig.PAY_APPID);
		payConfig.put("appsecret", WechatConfig.PAY_APPSECRET);
		payConfig.put("mchid", WechatConfig.PAY_MCHID);
		payConfig.put("mchkey", WechatConfig.PAY_PARTNERKEY);
		payConfig.put("payUrl", WechatConfig.PAY_URL);
		return payConfig;
	}
	
	/**
	 * 获取默认的支付宝即时到账支付配置
	 * @return
	 */
	public static JSONObject getDefaultAliDirectPayConfig()
	{
		JSONObject payConfig = new JSONObject();
		payConfig.put("partner", AlipayConfig.partner);
		payConfig.put("seller_email", AlipayConfig.seller_email);
		payConfig.put("key", AlipayConfig.key);
		return payConfig;
	}

	/**
	 * 获取随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		// 随机数
		String currTime = getCurrTime();
		// 8位日期
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机数
		String strRandom = buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		return strTime + strRandom;
	}
	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 *
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
}
