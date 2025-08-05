package com.example.demo.interceptor;

import com.example.demo.Util.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component   //在容器中进行注册
public class logininterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("2");
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        System.out.println("3");
        String token = request.getHeader("token");
        System.out.println(token);
        return TokenUtil.verify(token);
        // 失败我们跳转回登录页面
//        request.setAttribute("msg","登录出错");
//        request.getRemoteHost();
//        request.getRequestDispatcher("/login").forward(request,response);
    }

}
