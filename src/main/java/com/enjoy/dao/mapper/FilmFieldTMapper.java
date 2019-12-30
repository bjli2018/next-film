package com.enjoy.dao.mapper;

import com.enjoy.controller.cinema.vo.CinemaFilmVO;
import com.enjoy.dao.entity.FilmFieldT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author bob
 * @since 2019-12-29
 */
public interface FilmFieldTMapper extends BaseMapper<FilmFieldT> {
    List<CinemaFilmVO> describeFieldList(@Param("cinameId") String cinameId);
}
