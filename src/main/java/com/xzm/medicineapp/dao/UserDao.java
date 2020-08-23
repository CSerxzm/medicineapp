package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class UserDao {

    @Resource
    public UserMapper userMapper;

    public User getUser(User user){
        return userMapper.getUser(user);
    }

    public List<User> getUsers(){
        return userMapper.getUsers();
    }

    public Integer addUser(User user){
        return userMapper.addUser(user);
    }

    public Integer delUser(String name){
        return userMapper.delUser(name);
    }

    public Integer updateUser(User user){
        return userMapper.updateUser(user);
    }

    public User getUserByName(String name){
        return userMapper.getUserByName(name);
    }
}
