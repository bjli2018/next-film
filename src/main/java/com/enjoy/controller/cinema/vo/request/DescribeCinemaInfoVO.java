package com.enjoy.controller.cinema.vo.request;

import com.enjoy.controller.common.BaseVO;
import com.enjoy.controller.exception.ParamErrorException;
import lombok.Data;

@Data
public class DescribeCinemaInfoVO extends BaseVO {

    private Integer brandId;
    private Integer hallType;
    private Integer districtId;
    private Integer pageSize;
    private Integer nowPage;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
