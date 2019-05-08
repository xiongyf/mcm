package com.kevin.mcm.sys.service.impl;

import com.kevin.mcm.sys.entity.User;
import com.kevin.mcm.sys.mapper.UserMapper;
import com.kevin.mcm.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2019-05-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
