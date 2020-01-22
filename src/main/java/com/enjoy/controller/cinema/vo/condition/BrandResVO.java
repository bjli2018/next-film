package com.enjoy.controller.cinema.vo.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandResVO implements Serializable {
    private String brandId;
    private String brandName;
    private boolean isActive;
}
