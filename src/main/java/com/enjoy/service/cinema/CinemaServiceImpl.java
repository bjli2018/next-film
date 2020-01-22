package com.enjoy.service.cinema;

import com.enjoy.controller.cinema.vo.*;
import com.enjoy.controller.cinema.vo.condition.AreaResVO;
import com.enjoy.controller.cinema.vo.condition.BrandResVO;
import com.enjoy.controller.cinema.vo.condition.HallTypeResVO;
import com.enjoy.controller.cinema.vo.request.DescribeCinemaInfoVO;
import com.enjoy.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private FilmFieldTMapper filmFieldMapper;
    @Autowired
    private FilmCinemaTMapper cinemaMapper;
    @Autowired
    private FilmHallFilmInfoTMapper filmInfoMapper;

    @Autowired
    private FilmBrandDictTMapper brandDictMapper;
    @Autowired
    private FilmAreaDictTMapper areaDictMapper;
    @Autowired
    private FilmHallDictTMapper hallDictMapper;

    @Override
    public List<CinemaVO> describeCinemaInfo(DescribeCinemaInfoVO describeCinemaInfoVO) {
        return null;
    }

    @Override
    public List<BrandResVO> describeBrandConditions(int brandId) {
        return null;
    }

    @Override
    public List<AreaResVO> describeAreaConditions(int areaId) {
        return null;
    }

    @Override
    public List<HallTypeResVO> describeHallTypeConditions(int hallTypeId) {
        return null;
    }

    @Override
    public CinemaDetailVO describeCinemaDetails(String cinemaId) {
        return null;
    }

    @Override
    public List<CinemaFilmVO> describeFieldsAndFilmInfo(String cinemaId) {
        return null;
    }

    @Override
    public CinemaFilmInfoVO describeCinemaFilmInfoByFieldId(String fieldId) {
        return null;
    }

    @Override
    public FieldHallInfoVO describeHallInfoByFieldId(String fieldId) {
        return null;
    }
}
