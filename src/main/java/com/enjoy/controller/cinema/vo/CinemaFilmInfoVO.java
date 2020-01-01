package com.enjoy.controller.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by BJLI on 2019/12/30.
 */
@Data
public class CinemaFilmInfoVO implements Serializable {
    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
}
