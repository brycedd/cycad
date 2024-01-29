package com.dd.cycad.interceptor;

import com.alibaba.fastjson.JSON;
import com.dd.cycad.cache.SimpleCache;
import com.dd.cycad.entity.User;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Bryce_dd 2024/1/6 21:47
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token) || StringUtils.isBlank(SimpleCache.get(token))) {
            response.setStatus(401);
            return false;
        }
        String userInfo = SimpleCache.get(token);
        User user = JSON.parseObject(userInfo, User.class);
        request.setAttribute("user", user);
        return true;
    }
}
