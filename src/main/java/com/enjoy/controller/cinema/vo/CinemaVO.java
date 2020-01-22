package com.enjoy.controller.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 影院信息列表实体
 */
@Data
public class CinemaVO implements Serializable {
    private String uuid;
    private String cinemaName;
    private String address;
    private String minimumPrice;
}
