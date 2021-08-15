package com.jiangxia.blogofspringboot.repository;

import com.jiangxia.blogofspringboot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: 江夏
 * @Date: 2021/08/11/22:41
 * @Description: UserService实现类
 * @Repository注解可以标记在任何的类上，用来表明该类是用来执行与数据库相关的操作（即dao对象），并支持自动处理数据库操作产生的异常
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    /***
    * @Description:唯一id
    * @Param:
    * @return:
    * @Author: 江夏
    * @Date: 2021/8/12
    */
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long,User> userMap = new ConcurrentHashMap<>();
    @Override
    /***
    * @Description: 用户存在则update，不存在则新建
    * @Param: [user]
    * @return: com.jiangxia.blogofspringboot.entity.User
    * @Author: 江夏
    * @Date: 2021/8/12
    */
    public User saveOrUpdateUser(User user) {
        Long id= user.getId();
        // id为空，则user不存在，新建user
        if(id == null){
            // 生成唯一的id
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }

    /***
    * @Description:  删除用户
    * @Param: [id]
    * @return: void
    * @Author: 江夏
    * @Date: 2021/8/12
    */
    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    /***
    * @Description:根据id查询用户
    * @Param: [id]
    * @return: com.jiangxia.blogofspringboot.entity.User
    * @Author: 江夏
    * @Date: 2021/8/12
    */

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<User>(this.userMap.values());
    }
}
