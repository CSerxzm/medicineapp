package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Forum;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface ForumMapper {

    //得到论坛
    public List<Forum> getForums();
    //得到论坛
    public Forum getForumById(Integer id);
    //添加论坛
    public Integer addForum(Forum forum);
    //删除论坛
    public Integer delForumById(Integer id);

}
