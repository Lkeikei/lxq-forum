package com.lxq.forum.controller;

import com.lxq.forum.entity.DiscussPost;
import com.lxq.forum.entity.Page;
import com.lxq.forum.entity.User;
import com.lxq.forum.service.DiscussPostService;
import com.lxq.forum.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 娄须强
 * @CreateTime: 2023-04-23  11:31
 */
@Controller
public class HomeController {
    @Resource
    private DiscussPostService discussPostService;
    @Resource
    UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){

        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if(list != null){
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }

        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}
