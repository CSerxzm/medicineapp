package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.service.CommentService;
import com.xzm.medicineapp.service.HealthService;
import org.apache.ibatis.annotations.Param;
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
public class CommentController {

    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping("/getcommentsbyforumid")
    public String getCommentsByForumId(Integer forum_id){
        List<Comment> commentList = commentService.getCommentsByForumId(forum_id);
        return JSON.toJSONString(commentList);
    }
    @ResponseBody
    @RequestMapping("/addcomment")
    public String addComment(Comment comment){
        Integer result = commentService.addComment(comment);
        return JSON.toJSONString(comment);
    }
    @ResponseBody
    @RequestMapping("/delcommentbyid")
    public String delCommentById(Integer id){
        Integer result = commentService.delCommentById(id);
        return JSON.toJSONString(result);
    }
    /*************************后台管理*************************/

    @GetMapping("/back/comments")
    public String backComments(ModelMap modelMap){
        Collection<Comment> comments = commentService.getComments();
        modelMap.addAttribute("comments",comments);
        return "comment/list";
    }

    @DeleteMapping("/back/comment/{id}")
    public String deleteComment(@PathVariable("id") Integer id){
        commentService.delCommentById(id);
        return "redirect:/back/comments";
    }
}
