package com.enjoy.controller.user;

import lombok.Data;

@Data
public class EnrollUserVO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
}
