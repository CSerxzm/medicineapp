package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.mapper.CommentMapper;
import com.xzm.medicineapp.mapper.HealthMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class CommentDao {

    @Resource
    public CommentMapper commentMapper;

    //得到评论列表
    public List<Comment> getCommentsByForumId(Integer forum_id){
        return commentMapper.getCommentsByForumId(forum_id);
    }
    //添加评论
    public Integer addComment(Comment comment){
        return commentMapper.addComment(comment);
    }
    //删除评论
    public Integer delCommentById(Integer id){
        return commentMapper.delCommentById(id);
    }
}