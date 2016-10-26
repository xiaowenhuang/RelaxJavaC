package com.sven.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 是否登陆的拦截器
 * Created by sven on 2016/10/26.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //判断url是否是公开地址（实际使用时将公开地址配置在文件中）
        //这里公开地址是登陆提交的地址
        if(url.indexOf("login") > 0){
            //如果进行登陆提交，放行
            return true;
        }
        //判断session
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        if(account != null){
            //身份存在，放行
            return true;
        }
        //执行这里表示用户身份需要验证，跳转到登陆页面
        request.getRequestDispatcher("/login/index?tips=login").forward(request,response);
        return false;
    }

    //进入handler之后，返回ModelAndView之前执行
    //应用场景从ModelAndView出发：将公用的模型数据在这里放在ModelAndView里面
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor.postHandle()");
    }

    //handler执行完毕后执行此方法
    //可以使用统一的异常处理,统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("HandlerInterceptor.afterCompletion()");
    }
}
