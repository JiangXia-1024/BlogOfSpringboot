package com.jiangxia.blogofspringboot.entity;

/**
 * @Auther: Administrator
 * @Date: 2021/08/11/22:27
 * @Description:
 */
public class User  {

    /***
    * @Description: userid
    * @Param: 
    * @return: 
    * @Author: Administrator
    * @Date: 2021/8/11 
    */
    private Long id;

    private String name;

    private String email;

    /***
    * @Description: 无参构造器
    * @Param: []
    * @return:
    * @Author:
    * @Date:
    */
    public User() {

    }

    /***
    * @Description: 有参构造函数
    * @Param: [id, name, email]
    * @return:
    * @Author:
    * @Date:
    */

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
