package com.dd.cycad.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bryce_dd 2024/1/6 21:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String userName;
    private String password;
}
