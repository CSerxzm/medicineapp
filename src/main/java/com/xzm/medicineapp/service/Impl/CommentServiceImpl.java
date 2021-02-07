package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.dao.CommentDao;
import com.xzm.medicineapp.dao.ForumDao;
import com.xzm.medicineapp.service.CommentService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    ForumDao forumDao;

    public List<Comment> getComments(PageModel pageModel){
        Integer count = commentDao.getCount();
        pageModel.setRecordCount(count);
        return commentDao.getComments(pageModel);
    }
    public List<Comment> getCommentsByForumId(Integer forum_id){
        return commentDao.getCommentsByForumId(forum_id);
    }

    @Transactional
    public Integer addComment(Comment comment){
        Integer forumId = comment.getForumId();
        //加评论
        forumDao.addComments(forumId);
        return commentDao.addComment(comment);
    }

    @Transactional
    public Integer delCommentById(Integer id){
        Integer forumIdbyId = commentDao.getForumIdbyId(id);
        forumDao.delComments(forumIdbyId);
        return commentDao.delCommentById(id);
    }
}
