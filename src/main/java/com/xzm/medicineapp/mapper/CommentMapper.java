package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface CommentMapper {

    //得到所有
    List<Comment> getComments(PageModel pageModel);
    //得到评论列表
    List<Comment> getCommentsByForumId(Integer forum_id);
    //添加评论
    Integer addComment(Comment comment);
    //删除评论
    Integer delCommentById(Integer id);

    Integer getCount();

    /**
     * 通过评论的id找到forum_id
     * @param id
     * @return
     */
    Integer getForumIdbyId(Integer id);

    /**
     * 通过用户名找到该评论
     * @param name
     * @return
     */
    List<Comment> getCommentsByUserName(String name);

    /**
     * 通过用户名删除评论
     * @param name
     * @return
     */
    Integer delCommentsByUserName(String name);

    /**
     * 通过论坛的标识删除评论
     * @param id
     * @return
     */
    Integer delCommentsByForumId(Integer id);
}
