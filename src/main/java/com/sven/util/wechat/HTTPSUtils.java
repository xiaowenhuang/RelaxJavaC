package com.sven.util.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author vitoHuang
 * @Time 2015年8月14日
 * @Mark HTTPS请求工具
 */
public class HTTPSUtils{
    protected static final Logger log = Logger.getLogger(HTTPSUtils.class);
	/**
	 * HTTPS json 请求
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式 POST/GET
	 * @param msg json方式的请求参数
	 * @return 返回相应的字符串 异常会输出null
	 */
	public static String httpRequest(String requestUrl, String requestMethod, String msg){

    	OutputStream outputStream = null;
    	InputStream inputStream = null;
    	try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != msg) {
            	outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(msg.getBytes("UTF-8"));
            }

            // 将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            
            httpUrlConn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:"+e.getMessage());
        }finally{
        	if(outputStream != null)try{outputStream.close();}catch (Exception e) {}
        	if(inputStream != null)try{inputStream.close();;}catch (Exception e) {}
        }
        return null;
    }
    
    /**
     * HTTPS json 请求 
     * @param requestUrl
     * @param requestMethod
     * @param msg
     * @return 对字符串进行封装成JSON
     */
    public static JSONObject httpRequestToJSON(String requestUrl, String requestMethod, String msg){
    	String json = httpRequest(requestUrl, requestMethod, msg);
    	JSONObject jsonObject = null;
    	if(StringUtils.isNotBlank(json)) jsonObject = JSON.parseObject(json);
    	return jsonObject;
    }
}
