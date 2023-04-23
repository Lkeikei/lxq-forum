package com.lxq.forum.service;

import com.lxq.forum.entity.DiscussPost;
import com.lxq.forum.mapper.DiscussPostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 娄须强
 * @CreateTime: 2023-04-23  11:15
 */
@Service
public class DiscussPostService {
    @Resource
    DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(userId, offset, limit);
        return discussPosts;
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
