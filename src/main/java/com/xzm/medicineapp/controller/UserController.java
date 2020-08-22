package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:19
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user){
        boolean flag = userService.login(user);
        return JSON.toJSONString(flag);
    }
    @ResponseBody
    @RequestMapping("/getUsers")
    public String getUsers(){
        List<User> users = userService.getUsers();
        return JSON.toJSONString(users);
    }
}
