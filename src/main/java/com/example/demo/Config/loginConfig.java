package com.example.demo.Config;


import com.example.demo.interceptor.logininterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置类
@Configuration
public class loginConfig implements WebMvcConfigurer {

    @Autowired
    logininterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")   //默认对所有请求进行拦截
                .excludePathPatterns("/t1/userLogin","/t1/static/**","/t1/reg");     //对login页面和静态资源不拦截
    }
}
