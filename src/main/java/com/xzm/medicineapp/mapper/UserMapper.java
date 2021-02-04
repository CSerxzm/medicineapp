package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface UserMapper {

    User getUser(User user);
    List<User> getUsers(PageModel pageModel);
    Integer addUser(User user);
    Integer delUser(String name);
    Integer updateUser(User user);
    User getUserByName(String name);
    Integer getCount();

    /**
     * 注册用户
     * @param user
     * @return
     */
    Integer registUser(User user);

    /**
     * 更新用户，除了用户名和权限
     * @param user
     * @return
     */
    Integer updateUserWithoutPassAndAuthority(User user);

    /**
     * 更新密码
     * @param user
     * @return
     */
    Integer updateUserPass(User user);
}
