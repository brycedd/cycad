package com.dd.cycad.controller;

import com.alibaba.fastjson.JSON;
import com.dd.cycad.cache.SimpleCache;
import com.dd.cycad.dto.BaseResponse;
import com.dd.cycad.dto.TokenDTO;
import com.dd.cycad.entity.User;
import com.dd.cycad.http.HttpUtil;
import com.dd.cycad.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Bryce_dd 2024/1/6 21:22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @PostMapping("/login")
    public BaseResponse<TokenDTO> login(@RequestBody User user) {
        if ("dd".equals(user.getName()) && "123".equals(user.getEmail())) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            User dd = User.builder().name("dd").build();
            SimpleCache.put(token, JSON.toJSONString(dd));
            return HttpUtil.success(TokenDTO.builder().token(token).build());
        }
        return HttpUtil.loginFail();
    }

    @GetMapping("/mysqlQueryTest/{id}")
    public BaseResponse<?> mysqlQueryTest(@PathVariable Long id) {
        User user = userMapper.selectById(id);
        return HttpUtil.success(user);
    }
}
