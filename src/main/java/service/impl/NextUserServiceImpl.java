package service.impl;

import com.enjoy.dao.entity.NextUser;
import com.enjoy.dao.mapper.NextUserMapper;
import service.INextUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bob
 * @since 2019-11-03
 */
@Service
public class NextUserServiceImpl extends ServiceImpl<NextUserMapper, NextUser> implements INextUserService {

}
