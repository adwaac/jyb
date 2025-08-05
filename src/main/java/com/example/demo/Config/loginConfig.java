package com.example.demo.Config;


//import com.example.demo.interceptor.logininterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
////@Configuration 告诉springboot这是一个配置类
//@Configuration
//public class loginConfig implements WebMvcConfigurer {
//
//    @Autowired
//    logininterceptor loginInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")   //默认对所有请求进行拦截
//                .excludePathPatterns("/userLogin","/static/**","/reg");     //对login页面和静态资源不拦截
//    }
//}
