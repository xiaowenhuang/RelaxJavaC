package com.sven.service.pay;

import com.alibaba.fastjson.JSONObject;
import com.sven.model.wechat.pay.WxPay;

/**
 * Created by sven on 2016/10/27.
 */
public interface WechatPayService {
    String getPackage(WxPay wxPay, JSONObject payConfig);
}
