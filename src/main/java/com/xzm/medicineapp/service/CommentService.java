package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.dao.CommentDao;
import com.xzm.medicineapp.dao.ForumDao;
import com.xzm.medicineapp.dao.HealthDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
public interface CommentService {

    List<Comment> getComments(PageModel pageModel);

    List<Comment> getCommentsByForumId(Integer forum_id);

    Integer addComment(Comment comment);

    Integer delCommentById(Integer id);

}
