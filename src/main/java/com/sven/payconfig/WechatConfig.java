package com.sven.payconfig;


/**
 * 微信公众号默认配置(jfinal启动时赋值)
 * @author DeaconLi
 *
 */
public class WechatConfig 
{
	/**
	 *
	 * 统一登陆公众号配置
	 */
	public static String LOGIN_APPID = null;
	
	public static String LOGIN_APPSECRET = null;
	
	
	
	/**
	 *
	 * 统一收款公众号配置
	 *
	 */
	public static String PAY_APPID = null;
	
	public static String PAY_APPSECRET = null;
	
	public static String PAY_MCHID = null;
	
	public static String PAY_PARTNERID = null;
	
	public static String PAY_PARTNERKEY = null;
	
	public static String PAY_URL = null;
	
	/**
	 *
	 * 统一分享公众号配置
	 */
	public static String SHARE_APPID = null;
	
	public static String SHARE_APPSECRET = null;
	
	
	
	/**
	 * 国通公众号参数配置
	 */
	public static String WXOPEN_APPID = "wx5002d7a6066acc66";
	
	public static String WXOPEN_APPSECRET = "ae4d6f84833830a2fd8880912171bf0b";
	
	public static String WXOPEN_TOKEN = "quanzicn";
	
	public static String WXOPEN_ENCODING_AESKEY = "qwertyuiopasdfghjklzxcvbnm12345678901234567";
	
	//证书URL
	public static String APICLIENT_CERT=null;
}
