package com.dd.cycad.controller;

import com.dd.cycad.entity.User;
import com.dd.cycad.http.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Bryce_dd 2023/12/19 22:47
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/dd")
    public String demo() {
        User user = HttpUtil.getUser();
        String userName = user == null ? "world" : user.getName();
        return "hello " + userName + "!";
    }
}
