package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Comment;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface CommentMapper {

    //得到评论列表
    public List<Comment> getCommentsByForumId(Integer forum_id);
    //添加评论
    public Integer addComment(Comment comment);
    //删除评论
    public Integer delCommentById(Integer id);

}
