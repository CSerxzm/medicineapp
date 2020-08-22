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
}
