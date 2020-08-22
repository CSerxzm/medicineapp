package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.service.FoodService;
import com.xzm.medicineapp.service.ForumService;
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
public class ForumController {

    @Autowired
    private ForumService forumService;

    @ResponseBody
    @RequestMapping("/getForums")
    public String getForums(){
        List<Forum> forumList = forumService.getForums();
        return JSON.toJSONString(forumList);
    }
    @ResponseBody
    @RequestMapping("/getForumById")
    public String getForumById(Integer id){
        Forum forum = forumService.getForumById(id);
        return JSON.toJSONString(forum);
    }
    @ResponseBody
    @RequestMapping("/addForum")
    public String addForum(Forum forum){
        Integer result = forumService.addForum(forum);
        return  JSON.toJSONString(forum);
    }
    @ResponseBody
    @RequestMapping("delForumById")
    public String delForumById(Integer id){
        Integer result = forumService.delForumById(id);
        return  JSON.toJSONString(result);
    }

}
