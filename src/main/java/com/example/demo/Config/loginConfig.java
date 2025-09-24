package com.example.demo.Config;


import com.example.demo.interceptor.logininterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class loginConfig implements WebMvcConfigurer {
    @Autowired
    logininterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/ti/u")
                //.addPathPatterns("/**")   //默认对所有请求进行拦截
                .excludePathPatterns("/t1/userLogin","/t1/static/**","/t1/reg","/O1/**","/O1","/JYB/**","/JYB","/file/**","/file");
    }
}
