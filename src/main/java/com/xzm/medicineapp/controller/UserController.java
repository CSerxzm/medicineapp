package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.service.UserService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
        User result = userService.login(user);
        return JSON.toJSONString(result);
    }
    @ResponseBody
    @RequestMapping("/getusers")
    public String getUsers(PageModel pageModel){
        List<User> users = userService.getUsers(pageModel);
        return JSON.toJSONString(users);
    }

    /**
     * 注册用户，只是用户名和密码
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/registuser")
    public String registUser(User user){
        user.setAuthority("user");
        user.setImage("http://47.102.155.48:8080/pic_medicineapp/head1.png");
        user.setSex(1);//男性
        user.setConstellation("天蝎座");
        Integer flag = userService.registUser(user);
        return JSON.toJSONString(flag);
    }

    /**
     * 更新用户信息，除了密码，权限
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateuserwithoutpassandauthority")
    public Integer updateUserWithoutPassAndAuthority(User user){
        return  userService.updateUserWithoutPassAndAuthority(user);
    }

    /**
     * 更新用户密码
     * @param user
     * @param oldPass
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateuserpass")
    public Integer updateUserPass(User user,String oldPass){
        return userService.updateUserPass(user,oldPass);
    }

    /*************************后台管理*************************/
    @RequestMapping("/back/login")
    public String backLogin(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession httpSession){
        if(userService.login(new User(username,password))!=null){
            //为了防止表单重复提交，可以设置网页重定向
            httpSession.setAttribute("loginUser",username);
            return "redirect:/back/index";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/back/index")
    public String backIndex(){
        return "index";
    }
    @RequestMapping("/back/logout")
    public String backLogout(HttpSession httpSession){
        httpSession.invalidate();
        return "login";
    }

    //查询所有员工返回列表页面
    @GetMapping("/back/users")
    public String backUsers(ModelMap modelMap,PageModel pageModel){
        Collection<User> users = userService.getUsers(pageModel);
        modelMap.addAttribute("users",users);
        return "user/list";
    }

    //来到员工添加页面
    @GetMapping("/back/user")
    public String toAddPage(){
        return "user/add";
    }
    //员工添加
    @PostMapping("/back/user")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/back/users";
    }
    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/back/user/{name}")
    public String toEditPage(@PathVariable("name") String name, ModelMap modelMap){
        User user = userService.getUserByName(name);
        modelMap.addAttribute("user",user);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "user/add";
    }

    @PutMapping("/back/user")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/back/users";
    }

    //员工删除
    @DeleteMapping("/back/user/{name}")
    public String deleteUser(@PathVariable("name") String name){
        userService.delUser(name);
        return "redirect:/back/users";
    }
}
