package com.dd.cycad.dto;

import lombok.Data;

/**
 * @author Bryce_dd 2024/1/6 21:26
 */
@Data
public class BaseResponse<T> {

    private String code;
    private T data;
    private String msg;

    public BaseResponse(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
