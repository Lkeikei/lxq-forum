package com.lxq.forum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 娄须强
 * @CreateTime: 2023-04-22  20:01
 */
@RestController
@RequestMapping("/lxq")
public class TestController {
    @GetMapping("/info")
    public String info(){
        return "hi springboot";
    }
}
