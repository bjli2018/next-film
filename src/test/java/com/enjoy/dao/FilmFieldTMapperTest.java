package com.enjoy.dao;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.enjoy.NextFilmApplication;
import com.enjoy.controller.cinema.vo.CinemaFilmInfoVO;
import com.enjoy.controller.cinema.vo.CinemaFilmVO;
import com.enjoy.controller.cinema.vo.FieldHallInfoVO;
import com.enjoy.dao.entity.NextUser;
import com.enjoy.dao.mapper.FilmFieldTMapper;
import com.enjoy.dao.mapper.NextUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NextFilmApplication.class)
public class FilmFieldTMapperTest {
    @Resource
    private FilmFieldTMapper filmFieldTMapper;

    @Test
    public void testDescribeFieldList() throws Exception {
        List<CinemaFilmVO> filmInfoList = filmFieldTMapper.describeFieldList("1");
        System.out.println(filmInfoList);
    }

    @Test
    public void testDescribeFilmInfo() throws Exception {
        CinemaFilmInfoVO cinemaFilmInfoVO = filmFieldTMapper.describeFilmInfo("1");
        System.out.println(cinemaFilmInfoVO);
    }

    @Test
    public void testDescribeHallInfo() throws Exception {
        FieldHallInfoVO fieldHallInfoVO = filmFieldTMapper.describeHallInfo("1");
        System.out.println(fieldHallInfoVO);
    }
}
