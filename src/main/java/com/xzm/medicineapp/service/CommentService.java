package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.dao.CommentDao;
import com.xzm.medicineapp.dao.HealthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<Comment> getComments(){
        return commentDao.getComments();
    }
    public List<Comment> getCommentsByForumId(Integer forum_id){
        return commentDao.getCommentsByForumId(forum_id);
    }

    public Integer addComment(Comment comment){
        return commentDao.addComment(comment);
    }

    public Integer delCommentById(Integer id){
        return commentDao.delCommentById(id);
    }
}
