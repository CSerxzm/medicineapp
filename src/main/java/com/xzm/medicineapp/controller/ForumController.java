package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.service.FoodService;
import com.xzm.medicineapp.service.ForumService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 3052
 * @create 2020-08-21 21:19
 */
@Controller
public class ForumController {

    @Autowired
    private ForumService forumService;

    @ResponseBody
    @RequestMapping("/getforums")
    public String getForums(PageModel pageModel){
        List<Forum> forumList = forumService.getForums(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",forumList);
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @RequestMapping("/getforumbyid")
    public String getForumById(Integer id){
        Forum forum = forumService.getForumById(id);
        return JSON.toJSONString(forum);
    }
    @ResponseBody
    @RequestMapping("/addforum")
    public String addForum(Forum forum,String name){
        User user = new User();
        user.setName(name);
        forum.setUser(user);
        Integer result = forumService.addForum(forum);
        return  JSON.toJSONString(forum);
    }
    @ResponseBody
    @RequestMapping("delforumbyid")
    public String delForumById(Integer id){
        Integer result = forumService.delForumById(id);
        return  JSON.toJSONString(result);
    }
    /*************************后台管理*************************/

    @GetMapping("/back/forums")
    public String backForums(ModelMap modelMap,PageModel pageModel){
        Collection<Forum> forums = forumService.getForums(pageModel);
        modelMap.addAttribute("forums",forums);
        return "forum/list";
    }

    @DeleteMapping("/back/forum/{id}")
    public String deleteForum(@PathVariable("id") Integer id){
        forumService.delForumById(id);
        return "redirect:/back/forums";
    }
}
