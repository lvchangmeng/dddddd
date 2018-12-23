package com.itheima.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
       if(handler instanceof DefaultServletHttpRequestHandler){
           return true;
       }

        HttpSession session = request.getSession();
       if(session!=null && session.getAttribute("user")!=null){
           return true;
       }else {
           try {
               response.sendRedirect(request.getContextPath()+"/index.jsp");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

        return false;
    }
}
