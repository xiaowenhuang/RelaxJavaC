package com.sven.util.wechat;

import java.net.URLEncoder;

import com.sven.model.wechat.pay.AccessToken;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;

public class OpenidUtils 
{
	private static final Logger log = Logger.getLogger(OpenidUtils.class);

	private final static String OAUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={REDIRECT_URI}&response_type=code&scope={SCOPE}&state=STATE#wechat_redirect";
	
	private final static String CODE_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={APPID}&secret={SECRET}&code={CODE}&grant_type=authorization_code";
	
	public static AccessToken getOpenid(JSONObject payConfig,String code){
		
		String url = CODE_ACCESS_TOKEN_URL.replace("{APPID}", payConfig.getString("appid")).replace("{SECRET}", payConfig.getString("appsecret")).replace("{CODE}", code);
		JSONObject jsonObject = HTTPSUtils.httpRequestToJSON(url, "GET", null);
		
		AccessToken accessToken = null;
		
		log.error("jsonObject: " + jsonObject.toJSONString());
		
		if(jsonObject != null){
			accessToken = new AccessToken();
			accessToken.setToken(jsonObject.getString("access_token"));
			accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
			accessToken.setRefreshToken(jsonObject.getString("refresh_token"));
			accessToken.setOpenId(jsonObject.getString("openid"));
			accessToken.setScope(jsonObject.getString("scope"));
		}
		return accessToken;
	}
	
	
	/**
	 * 
	 * @param appId
	 * @param redirect_url
	 * @param scope "snsapi_base" "snsapi_userinfo"
	 * @return
	 */
	public static String getCodeRequest(String appId, String redirect_url, String scope){ 
        String url  = OAUTH_URL.replace("{APPID}", appId).replace("{REDIRECT_URI}", redirect_url).replace("{SCOPE}", scope);
        return url; 
    } 
	
	/**
	 * 参数url编码
	 * @param str
	 * @return
	 */
	public static String urlEnodeUTF8(String str){ 
        String result = str; 
        try { 
            result = URLEncoder.encode(str,"UTF-8"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return result; 


    } 
	
}
