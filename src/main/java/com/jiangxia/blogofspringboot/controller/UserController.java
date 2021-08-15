package com.jiangxia.blogofspringboot.controller;

import com.jiangxia.blogofspringboot.entity.User;
import com.jiangxia.blogofspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: 江夏
 * @Date: 2021/08/11/22:29
 * @Description: User控制类
 */
@RestController
//请求路径
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    /***
    * @Description:查询所有用户  get方法 restful风格
    * @Param:
    * @return:
    * @Author: 江夏
    * @Date: 2021/8/12
    */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUsers());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

   /***
   * @Description: 根据id查询用户信息
   * @Param: [id, model]
   * @return: org.springframework.web.servlet.ModelAndView
   * @Author: 江夏
   * @Date: 2021/8/12
   */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userRepository.getUserById(id));
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /***
    * @Description: 获取创建表单页面
    * @Param: [model]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: 江夏
    * @Date: 2021/8/14
    */

    @GetMapping("/")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }
    /***
    * @Description: 保存或者更新用户页面
    * @Param: [user]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: 江夏
    * @Date: 2021/8/14
    */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("users/form", "userModel", user);
    }

    /***
    * @Description: 获取修改用户的页面
    * @Param:
    * @return:
    * @Author: 江夏
    * @Date: 2021/8/14
    */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id,Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("user/form", "userModel", model);
    }

    /***
    * @Description: 删除用户页面
    * @Param: [id]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: 江夏
    * @Date: 2021/8/14
    */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }
}
