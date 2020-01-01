package com.enjoy.controller.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by BJLI on 2019/12/30.
 */
@Data
public class FieldHallInfoVO implements Serializable {
    private String hallFieldId;
    private String hallName;
    private String price;
    private String seatFile;
}
