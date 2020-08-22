package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.User;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface UserMapper {

    public User getUser(User user);
    public List<User> getUsers();

}
