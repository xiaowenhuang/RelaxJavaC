package com.sven.util.wechat;

import com.sven.model.wechat.pay.WxPrepay;
import com.sven.util.wechat.HTTPSUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class WeiXinPayUtil {
	private final static String WeXinPay_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static String getPrepayId(String xml,String method){
		return HTTPSUtils.httpRequest(WeXinPay_URL, method, xml);
	}

	@SuppressWarnings("deprecation")
	private static XStream xstream = new XStream(
			new XppDriver(new
								  XmlFriendlyReplacer("_-", "_"){
									  public HierarchicalStreamWriter createWriter(Writer out) {
										  return new PrettyPrintWriter(out) {
											  // 对所有xml节点的转换都增加CDATA标记
											  boolean cdata = true;

											  @SuppressWarnings({ "rawtypes" })
											  public void startNode(String name, Class clazz) {
												  super.startNode(name, clazz);
											  }

											  protected void writeText(QuickWriter writer, String text) {
												  if (cdata) {
													  writer.write("<![CDATA[");
													  writer.write(text);
													  writer.write("]]>");
												  } else {
													  writer.write(text);
												  }
											  }
										  };
									  }
								  })
	);

	public static String toXml(WxPrepay wxPrepay){
		xstream.alias("xml", wxPrepay.getClass());
		return xstream.toXML(wxPrepay);
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

	/**
	 * 元转换成分
	 * @param amount
	 * @return
	 */
	public static String getMoney(String amount) {
		if(amount==null){
			return "";
		}
		// 金额转化为分为单位
		String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额  
		int index = currency.indexOf(".");
		int length = currency.length();
		Long amLong = 0l;
		if(index == -1){
			amLong = Long.valueOf(currency+"00");
		}else if(length - index >= 3){
			amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));
		}else if(length - index == 2){
			amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);
		}else{
			amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");
		}
		return amLong.toString();
	}

	/**
	 * ArrayToXml
	 * @param arr
	 * @return
	 */
	public static String ArrayToXml(Map<String, String> arr) {
		String xml = "<xml>";

		Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue();
			if (IsNumeric(val)) {
				xml += "<" + key + ">" + val + "</" + key + ">";

			} else
				xml += "<" + key + "><![CDATA[" + val + "]]></" + key + ">";
		}

		xml += "</xml>";
		return xml;
	}


	public static boolean IsNumeric(String str) {
		if (str.matches("\\d *")) {
			return true;
		} else {
			return false;
		}
	}

	public static Map<String,String> StringtoMap(String str){
		//log.error("respon_prepay_xml: " + str);
		Map<String,String> map = new LinkedHashMap<String,String>();

		try {
			Document document = DocumentHelper.parseText(str);
			Element root = document.getRootElement();
			List<Element> elementList = root.elements();
			for(Element e : elementList){
				map.put(e.getName(), e.getText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}



}
