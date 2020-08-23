package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.service.FoodService;
import com.xzm.medicineapp.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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
    public String getForums(){
        List<Forum> forumList = forumService.getForums();
        return JSON.toJSONString(forumList);
    }
    @ResponseBody
    @RequestMapping("/getforumbyid")
    public String getForumById(Integer id){
        Forum forum = forumService.getForumById(id);
        return JSON.toJSONString(forum);
    }
    @ResponseBody
    @RequestMapping("/addforum")
    public String addForum(Forum forum){
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
    public String backForums(ModelMap modelMap){
        Collection<Forum> forums = forumService.getForums();
        modelMap.addAttribute("forums",forums);
        return "forum/list";
    }

    @DeleteMapping("/back/forum/{id}")
    public String deleteForum(@PathVariable("id") Integer id){
        forumService.delForumById(id);
        return "redirect:/back/forums";
    }
}
