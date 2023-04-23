package com.lxq.forum.mapper;

import com.lxq.forum.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.kafka.common.protocol.types.Field;

/**
 * @Author: 娄须强
 * @CreateTime: 2023-04-22  21:10
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String userName);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, @Param("headerUrl") String headerUrl);

    int updatePassword(int id, String password);
}
