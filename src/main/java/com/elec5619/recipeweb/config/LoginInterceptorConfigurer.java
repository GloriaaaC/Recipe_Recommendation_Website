package com.elec5619.recipeweb.config;

import com.elec5619.recipeweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理拦截器的注册
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /**
     * Register customer Interceptor
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor loginInterceptor = new LoginInterceptor();
        // whitelist
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/js/**");
        patterns.add("/images/**");
        patterns.add("/fonts/**");

        patterns.add("/login");
        patterns.add("/register");
        patterns.add("/users/login");
        patterns.add("/users/reg");

        // what request need Interceptor
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");

        // what request do not need Interceptor
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}
