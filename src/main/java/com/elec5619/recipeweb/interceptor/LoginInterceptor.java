package com.elec5619.recipeweb.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * define a login Interceptor, if no login, redirect to login page
 */
public class LoginInterceptor implements HandlerInterceptor {

    // 在调用所有请求的方法之前，被自动调用的方法
    /**
     * check if there is UID in the session, if not, redirect to the login page
     * @param request
     * @param response
     * @param handler map URL and Controller
     * @return if False, reject the request
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute("uid");
        String view = request.getContextPath();
        if (object == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    // 在ModelAndView 对象返回之后，被自动调用的方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 在整个请求所有关联的资源被执行完毕最后所执行的方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
