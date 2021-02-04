package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface ForumMapper {

    //得到论坛
    List<Forum> getForums(PageModel pageModel);
    //得到论坛
    Forum getForumById(Integer id);
    //添加论坛
    Integer addForum(Forum forum);
    //删除论坛
    Integer delForumById(Integer id);

    Integer getCount();

    /**
     * 浏览量加1
     * @param id
     * @return
     */
    Integer addComments(Integer id);

}
