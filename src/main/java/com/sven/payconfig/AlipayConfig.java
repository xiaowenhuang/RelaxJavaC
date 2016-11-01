package com.sven.payconfig;

public class AlipayConfig 
{
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";
	
	// 默认的合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088021614943543";
	
	// 默认的收款支付宝账号
	public static String seller_email = "joekyzhang@cnitr.net";
	
	// 默认的商户的私钥
	public static String key = "x06hn6aliloyjzi9h74lld54ikmsbht7";
	
}
