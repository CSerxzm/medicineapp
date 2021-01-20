package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.dao.UserDao;
import com.xzm.medicineapp.service.UserService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 登录用户
     * @param user
     * @return
     */
    public User login(User user){
        String pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pass);
        User result = userDao.getUser(user);
        return result;
    }

    /**
     * 分页得到所有的用户
     * @param pageModel
     * @return
     */
    public List<User> getUsers(PageModel pageModel){
        Integer count = userDao.getCount();
        pageModel.setRecordCount(count);
        return userDao.getUsers(pageModel);
    }

    public Integer addUser(User user){
        return userDao.addUser(user);
    }

    /**
     * 删除用户
     * @param name
     * @return
     */
    public Integer delUser(String name){
        return userDao.delUser(name);
    }

    public Integer updateUser(User user){
        return userDao.updateUser(user);
    }

    /**
     * 得到用户名
     * @param name
     * @return
     */
    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Integer registUser(User user){
        User userByName = userDao.getUserByName(user.getName());
        if(userByName!=null){
            return 0;
        }
        String pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pass);
        return userDao.registUser(user);
    }

    /**
     * 保存用户的相关信息，除了用户密码和权限
     * @param user
     * @return
     */
    public Integer updateUserWithoutPassAndAuthority(User user){
        return  userDao.updateUserWithoutPassAndAuthority(user);
    }

    /**
     * 更新用户密码
     * @param user
     * @param oldPass
     * @return
     */
    public Integer updateUserPass(User user,String oldPass){
        User userByName = userDao.getUserByName(user.getName());
        String pass = DigestUtils.md5DigestAsHex(oldPass.getBytes());
        if(userByName.getPassword()!=pass){
            //密码错误，原有的
            return 0;
        }
        String newPass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(newPass);
        return userDao.updateUserPass(user);
    }
}
