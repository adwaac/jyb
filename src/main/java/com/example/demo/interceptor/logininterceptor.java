package com.example.demo.interceptor;

import com.example.demo.Util.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component   //在容器中进行注册
public class logininterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull Object handler) {
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        String token = request.getHeader("token");
        System.out.println(token);
        response.addHeader("token", token);
        return TokenUtil.verify(token);
    }

}
