/*
package com.sven.action.pay;

import com.alibaba.fastjson.JSONObject;
import com.sven.model.wechat.pay.AccessToken;
import com.sven.model.wechat.pay.WxPay;
import com.sven.service.pay.WechatPayService;
import com.sven.util.wechat.IpUtil;
import com.sven.util.wechat.OpenidUtils;
import com.sven.util.wechat.PayHelper;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

*
 * 微信支付入口
 * Created by sven on 2016/10/27.


public class WechatPayController {

    private WechatPayService wechatPayService;
*
     * 获取code可以换取openid


    public void index(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String orderID = request.getParameter("orderID");//获取下单页面传过来的订单ID
        String code = request.getParameter("code");//获取code,默认是为空，在下面会再次获取。
        String serverName = request.getParameter("serverName");//服务器名字

        JSONObject payConfig ;
        try {
            payConfig = PayHelper.getDefaultWechatPayConfig();
        } catch (Exception e) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        if (StringUtils.isBlank(code)) {
            String redirect_url = OpenidUtils.getCodeRequest(payConfig.getString("appid"),
                    OpenidUtils.urlEnodeUTF8(
                            payConfig.getString("payUrl") + orderID + "?serverName=" + request.getServerName()),
                    "snsapi_base");
            response.sendRedirect(redirect_url);
            return;
        } else {
            Orderg order = orderService.findOrder(orderID);//从数据库取出这个订单
            AccessToken accessToken = OpenidUtils.getOpenid(payConfig, code);
            WxPay wxPay = new WxPay();
            wxPay.setOpenId(accessToken.getOpenId());
            try {
                wxPay.setBody(orderService.getOrderGoodsDesc(orderID));
            } catch (ServiceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            wxPay.setOrderId(orderID);
            wxPay.setSpbillCreateIp(IpUtil.getIpAddress(request));
            wxPay.setTotalFee(order.getTotalFee());

            // 支付openid绑定到与userid绑定到表qz_third_bind
            orderService.updateThirdBindPayOpenid(accessToken.getOpenId(), orderID);

            // 设置支付token到ehcache缓存
            //CacheKit.put("wechat_pay_openid", order.getStr("orderNo"), accessToken.getOpenId());

            String payParam = wechatPayService.getPackage(wxPay, payConfig);//组织传回给jsp页面的微信支付参数

            //传回支付页面用作显示的参数
            request.setAttribute("order", order);//0
            request.setAttribute("orderID", orderID);
            request.setAttribute("orderNo", order.);//0
            request.setAttribute("orderType", order.getInt("orderType"));//0
            request.setAttribute("totalFee", PayHelper.penny2yuan(order.getLong("amount")));//0

            //传回支付页面用作传递给微信的参数
            request.setAttribute("serverName", "http://" + serverName);
            request.setAttribute("paySuccessUrl", "http://" + serverName + "/user/order/paySuccessPage");
            request.setAttribute("pay", payParam);
            request.getRequestDispatcher("/pay/wechatpayjsp").forward(request,response);
            //render("wxopenid.jsp");
        }
    }
}
*/
