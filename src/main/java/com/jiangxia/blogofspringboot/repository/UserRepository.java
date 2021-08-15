package com.jiangxia.blogofspringboot.repository;

import com.jiangxia.blogofspringboot.entity.User;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2021/08/11/22:34
 * @Description:
 */
public interface UserRepository {
    /***
    * @Description: 保存或者更新用户信息
    * @Param: [user]
    * @return: com.jiangxia.blogofspringboot.entity.User
    * @Author: 江夏
    * @Date: 2021/8/11 
    */
    User saveOrUpdateUser(User user);

    /***
    * @Description:根据id删除用户
    * @Param: [id]
    * @return: void
    * @Author: 江夏
    * @Date: 2021/8/11
    */
    void deleteUser(Long id);

    /***
    * @Description:根据id查询用户信息
    * @Param: [id]
    * @return: com.jiangxia.blogofspringboot.entity.User
    * @Author: 江夏
    * @Date: 2021/8/11
    */
    User getUserById(Long id);

    /***
     * @Description:批量获取用户列表
     * @Param: []
     * @return: java.util.List<com.jiangxia.blogofspringboot.entity.User>
     * @Author: 江夏
     * @Date: 2021/8/11
     */

    List<User> listUsers();




}
