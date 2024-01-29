package com.dd.cycad.controller;

import com.alibaba.fastjson.JSON;
import com.dd.cycad.cache.SimpleCache;
import com.dd.cycad.dto.BaseResponse;
import com.dd.cycad.dto.TokenDTO;
import com.dd.cycad.entity.User;
import com.dd.cycad.http.HttpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Bryce_dd 2024/1/6 21:22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public BaseResponse<TokenDTO> login(@RequestBody User user) {
        if ("dd".equals(user.getUserName()) && "123".equals(user.getPassword())) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            User dd = User.builder().userName("dd").build();
            SimpleCache.put(token, JSON.toJSONString(dd));
            return HttpUtil.success(TokenDTO.builder().token(token).build());
        }
        return HttpUtil.loginFail();
    }
}
