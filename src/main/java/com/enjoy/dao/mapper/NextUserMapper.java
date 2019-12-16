package com.enjoy.dao.mapper;

import com.enjoy.dao.entity.NextUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bob
 * @since 2019-11-03
 */
public interface NextUserMapper extends BaseMapper<NextUser> {
    List<NextUser> getUsers();
}
