package com.dd.cycad.http;

import com.dd.cycad.dto.BaseResponse;
import com.dd.cycad.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Bryce_dd 2024/1/6 21:27
 */
public class HttpUtil {

    public static<T> BaseResponse<T> success(T t) {
        return new BaseResponse<>("0", t, "成功");
    }

    public static <T> BaseResponse<T> loginFail() {
        return new BaseResponse<>("-1", null, "账号或密码错误！");
    }

    public static <T> BaseResponse<T> fail() {
        return new BaseResponse<>("-1", null, "系统异常");
    }

    public static User getUser() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            return (User)request.getAttribute("user");
        }
        return null;
    }
}
