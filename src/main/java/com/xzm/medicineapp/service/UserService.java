package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.dao.UserDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */

public interface UserService {

    /**
     * 登录用户
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 分页得到所有的用户
     *
     * @param pageModel
     * @return
     */
    List<User> getUsers(PageModel pageModel);

    Integer addUser(User user);

    /**
     * 删除用户
     *
     * @param name
     * @return
     */
    Integer delUser(String name);

    Integer updateUser(User user);

    /**
     * 得到用户名
     *
     * @param name
     * @return
     */
    User getUserByName(String name);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    Integer registUser(User user);

    /**
     * 保存用户的相关信息，除了用户密码和权限
     *
     * @param user
     * @return
     */
    User updateUserWithoutPassAndAuthority(User user);

    /**
     * 更新用户密码
     *
     * @param user
     * @param oldPass
     * @return
     */
    User updateUserPass(User user, String oldPass);
}
