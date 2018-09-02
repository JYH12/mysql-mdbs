package com.lsl.interceptor;

import com.lsl.po.User;
import com.lsl.service.TokenService;
import com.lsl.utils.CookieUtils;
import com.lsl.utils.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private JedisCluster jedisCluster;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtils.getCookieValue(request, "TOKEN");
        if (StringUtils.isBlank(token)){
            response.sendRedirect("/login");
            return false;
        }
        Message message = tokenService.getUserByToken(token);
        if (message.getStatus()!=200){
            response.sendRedirect("/login");
            return false;
        }
        User user = (User) message.getData();
        jedisCluster.expire(token,1800);
        request.setAttribute("user",user);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
