package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.service.CommentService;
import com.xzm.medicineapp.service.HealthService;
import org.apache.ibatis.annotations.Param;
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
public class CommentController {

    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping("/getCommentsByForumId")
    public String getCommentsByForumId(Integer forum_id){
        List<Comment> commentList = commentService.getCommentsByForumId(forum_id);
        return JSON.toJSONString(commentList);
    }
    @ResponseBody
    @RequestMapping("/addComment")
    public String addComment(Comment comment){
        Integer result = commentService.addComment(comment);
        return JSON.toJSONString(comment);
    }
    @ResponseBody
    @RequestMapping("/delCommentById")
    public String delCommentById(Integer id){
        Integer result = commentService.delCommentById(id);
        return JSON.toJSONString(result);
    }

}
