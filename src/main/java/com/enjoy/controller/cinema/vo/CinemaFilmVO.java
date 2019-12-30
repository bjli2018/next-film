package com.enjoy.controller.cinema.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by BJLI on 2019/12/30.
 */
@Data
public class CinemaFilmVO implements Serializable {
    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private List<FilmFieldVO> filmFields;
}
