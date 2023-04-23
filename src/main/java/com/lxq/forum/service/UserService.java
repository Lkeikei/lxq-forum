package com.lxq.forum.service;

import com.lxq.forum.entity.User;
import com.lxq.forum.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: 娄须强
 * @CreateTime: 2023-04-23  11:19
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public User findUserById(int userId){
        return userMapper.selectById(userId);
    }

}
