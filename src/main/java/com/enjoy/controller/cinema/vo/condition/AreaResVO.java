package com.enjoy.controller.cinema.vo.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class AreaResVO implements Serializable {
    private String areaId;
    private String areaName;
    private boolean isActive;
}
