package com.enjoy.service.cinema;

import com.enjoy.controller.cinema.vo.*;
import com.enjoy.controller.cinema.vo.condition.AreaResVO;
import com.enjoy.controller.cinema.vo.condition.BrandResVO;
import com.enjoy.controller.cinema.vo.condition.HallTypeResVO;
import com.enjoy.controller.cinema.vo.request.DescribeCinemaInfoVO;

import java.util.List;

public interface CinemaService {
    /*
        根据条件查询影院列表
     */
    List<CinemaVO> describeCinemaInfo(DescribeCinemaInfoVO describeCinemaInfoVO);

    /*
        获取查询条件
     */
    List<BrandResVO> describeBrandConditions(int brandId);
    List<AreaResVO> describeAreaConditions(int areaId);
    List<HallTypeResVO> describeHallTypeConditions(int hallTypeId);

    /*
       根据影院编号获取影院详情信息
     */
    CinemaDetailVO describeCinemaDetails(String cinemaId);

    /*
      根据影院编号获取场次信息
     */
    List<CinemaFilmVO> describeFieldsAndFilmInfo(String cinemaId);
    /*
      根据场次编号获取电影信息
    */
    CinemaFilmInfoVO describeCinemaFilmInfoByFieldId(String fieldId);

    /*
      根据场次编号获取放映厅信息
    */
    FieldHallInfoVO describeHallInfoByFieldId(String fieldId);
}
