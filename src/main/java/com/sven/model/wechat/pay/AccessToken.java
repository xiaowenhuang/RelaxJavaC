package com.sven.model.wechat.pay;

public class AccessToken {
	 // 获取到的凭证
    private String token;
    // 凭证有效时间，单位：秒
    private int expiresIn;
    //用户刷新access_token
    private String refreshToken;
    //粉丝的openId
    private String openId;
    //用户授权的作用域
    private String scope;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
