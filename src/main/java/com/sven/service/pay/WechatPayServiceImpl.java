package com.sven.service.pay;

import com.alibaba.fastjson.JSONObject;
import com.sven.model.wechat.pay.WxPay;
import com.sven.model.wechat.pay.WxPrepay;
import com.sven.payconfig.RequestHandler;
import com.sven.util.wechat.PayHelper;
import com.sven.util.wechat.WeiXinPayUtil;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 微信支付业务逻辑层
 * Created by sven on 2016/10/27.
 */
public class WechatPayServiceImpl implements WechatPayService {

    @Override
    public String getPackage(WxPay wxPay, JSONObject payConfig) {
        Map<String,String> map;
        String noceStr = PayHelper.getNonceStr();

        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("appid", payConfig.getString("appid"));
        packageParams.put("mch_id", payConfig.getString("mchid"));
        packageParams.put("nonce_str", noceStr);
        packageParams.put("body", wxPay.getBody());
        packageParams.put("attach", "");
        packageParams.put("out_trade_no", wxPay.getOrderId());

        // 这里写的金额为1 分到时修改
        packageParams.put("total_fee", wxPay.getTotalFee());
        packageParams.put("spbill_create_ip", wxPay.getSpbillCreateIp());

        String notify_url = "http://localhost:8080/front/wxpay/wxpay_notify_url";//微信支付成功后同步回调页面
        packageParams.put("notify_url", notify_url);

        String trade_type = "JSAPI";
        packageParams.put("trade_type", trade_type);
        packageParams.put("openid", wxPay.getOpenId());

        RequestHandler reqHandler = new RequestHandler(null, null);
        reqHandler.init(payConfig.getString("appid"), payConfig.getString("appsecret"), payConfig.getString("mchkey"));
        String sign = reqHandler.createSign(packageParams);


        WxPrepay wxPrepay = new WxPrepay();
        wxPrepay.setAppid(payConfig.getString("appid"));
        wxPrepay.setMch_id(payConfig.getString("mchid"));
        wxPrepay.setNonce_str(noceStr);
        wxPrepay.setSign(sign);
        wxPrepay.setBody(wxPay.getBody());
        wxPrepay.setOut_trade_no(wxPay.getOrderId());
        wxPrepay.setTotal_fee(wxPay.getTotalFee());
        wxPrepay.setSpbill_create_ip(wxPay.getSpbillCreateIp());
        wxPrepay.setNotify_url(notify_url);
        wxPrepay.setTrade_type(trade_type);
        wxPrepay.setOpenid(wxPay.getOpenId());
        wxPrepay.setAttach("");

        String xml = WeiXinPayUtil.toXml(wxPrepay);
        //log.error("post_prepay_xml: " + xml);
        //获取prepay_id
        map = WeiXinPayUtil.StringtoMap(WeiXinPayUtil.getPrepayId(xml, "POST"));

        //获取prepay_id后，拼接最后请求支付所需要的package
        SortedMap<String, String> finalpackage = new TreeMap<String, String>();
        String timestamp = WeiXinPayUtil.getTimeStamp();
        String packages = "prepay_id="+map.get("prepay_id");
        finalpackage.put("appId", payConfig.getString("appid"));
        finalpackage.put("timeStamp", timestamp);
        finalpackage.put("nonceStr", noceStr);
        finalpackage.put("package", packages);
        finalpackage.put("signType", "MD5");
        //要签名
        String finalsign = reqHandler.createSign(finalpackage);

        String finaPackage = "\"appId\":\"" + payConfig.getString("appid") + "\",\"timeStamp\":\"" + timestamp
                + "\",\"nonceStr\":\"" + noceStr + "\",\"package\":\""
                + packages + "\",\"signType\" : \"MD5" + "\",\"paySign\":\""
                + finalsign + "\"";

        return finaPackage;
    }


}
