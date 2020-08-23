package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean login(User user){
        User result = userDao.getUser(user);
        if(result==null)
            return false;
        else
            return true;
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public Integer addUser(User user){
        return userDao.addUser(user);
    }

    public Integer delUser(String name){
        return userDao.delUser(name);
    }

    public Integer updateUser(User user){
        return userDao.updateUser(user);
    }

    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }
}
