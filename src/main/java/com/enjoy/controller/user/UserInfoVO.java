package com.enjoy.controller.user;

import com.enjoy.controller.common.BaseVO;
import com.enjoy.controller.exception.ParamErrorException;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoVO extends BaseVO implements Serializable {
    private Integer id;
    private Integer uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    private String birthday;
    private String lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private Long beginTime;
    private Long updateTime;

    @Override
    public void checkParam() throws ParamErrorException {
        //加入验证逻辑
    }
}
