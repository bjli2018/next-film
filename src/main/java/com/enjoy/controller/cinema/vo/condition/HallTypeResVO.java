package com.enjoy.controller.cinema.vo.condition;

import lombok.Data;

import java.io.Serializable;

@Data
public class HallTypeResVO implements Serializable {
    private String hallTypeId;
    private String hallTypeName;
    private boolean isActive;
}
