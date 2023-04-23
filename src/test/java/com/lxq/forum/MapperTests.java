package com.lxq.forum;

import com.lxq.forum.entity.DiscussPost;
import com.lxq.forum.entity.User;
import com.lxq.forum.mapper.DiscussPostMapper;
import com.lxq.forum.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: 娄须强
 * @CreateTime: 2023-04-22  21:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ForumApplication.class)
public class MapperTests {

    @Autowired
    UserMapper userMapper;


    @Resource
    DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }


    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        discussPosts.forEach(discussPost -> System.out.println(discussPost));


        System.out.println(discussPostMapper.selectDiscussPostRows(0));
    }


}
