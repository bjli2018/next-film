package com.enjoy.dao;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
	public void testAddUser() throws Exception {
		NextUser nextUser = new NextUser();
        nextUser.setUserName("zhangsan");
        nextUser.setUserPwd("123456");
		int isSuccess = nextUserMapper.insert(nextUser);
		System.out.println("isSuccess=" + (isSuccess==1?true:false));
	}

	@Test
	public void testUpdateUser() throws Exception {
        NextUser nextUser = new NextUser();
        nextUser.setUuid(6);
        nextUser.setUserName("zhangsan");
        nextUser.setUserPwd("456");
        //int isSuccess = nextUserMapper.updateById(nextUser);

        AbstractWrapper abstractWrapper = new UpdateWrapper();
        abstractWrapper.eq("user_name","zhangsan");
        int isSuccess = nextUserMapper.updateById(nextUser);

        System.out.println("isSuccess=" + (isSuccess==1?true:false));
	}

	@Test
	public void testDeleteUser() throws Exception {
	    int id = 6;
        int isSuccess = nextUserMapper.deleteById(id);
        System.out.println("isSuccess=" + (isSuccess==1?true:false));
	}

    @Test
    public void testSelectUser() throws Exception {
        int id = 6;
        int isSuccess = nextUserMapper.deleteById(id);
        System.out.println("isSuccess=" + (isSuccess==1?true:false));
    }


    @Test
    public void testGetUsers() throws Exception {
        System.out.println(nextUserMapper.getUsers());
    }
}
