package com.lxq.forum.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.lxq.forum.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);


    int selectDiscussPostRows(@Param("userId") int userId);

}
