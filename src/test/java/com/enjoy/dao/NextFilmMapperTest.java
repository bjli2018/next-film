package com.enjoy.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enjoy.NextFilmApplication;
import com.enjoy.dao.entity.NextUser;
import com.enjoy.dao.mapper.NextUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NextFilmApplication.class)
public class NextFilmMapperTest {
	@Resource
    private NextUserMapper nextUserMapper;
	@Test
	public void testSelectById() throws Exception {
		NextUser nextUser = nextUserMapper.selectById(1);
		System.out.println(nextUser);
	}

}
