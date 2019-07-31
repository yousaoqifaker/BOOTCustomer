package com.qin.bootcustomer.interceptor;

import com.qin.bootcustomer.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: BootCustomer
 * @description: 登录拦截器
 * @author: qin
 * @create: 2019-07-18 11:27
 **/

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {
        String url=Request.getRequestURI();
        if (url.indexOf("/login.action")>=0){
            return true;
        }
        HttpSession session=Request.getSession();
        User user  = (User) session.getAttribute("USER_SESSION");
        if (user!=null){
            return true;
        }
        Request.setAttribute("msg","你还没有登录，请先登录");
        Request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(Request,Response);
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
