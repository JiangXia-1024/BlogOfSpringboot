package com.jiangxia.blogofspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
* @Description: helloworld 测试controller
* @Param: 
* @return: 
* @Author: jiangxia
* @Date: 2021/8/10
*/

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
