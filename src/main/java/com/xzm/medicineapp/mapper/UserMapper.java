package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface UserMapper {

    public User getUser(User user);
    public List<User> getUsers(PageModel pageModel);
    public Integer addUser(User user);
    public Integer delUser(String name);
    public Integer updateUser(User user);
    public User getUserByName(String name);
    public Integer getCount();

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Integer registUser(User user);

    /**
     * 更新用户，除了用户名和权限
     * @param user
     * @return
     */
    public Integer updateUserWithoutPassAndAuthority(User user);

    /**
     * 更新密码
     * @param user
     * @return
     */
    public Integer updateUserPass(User user);
}
