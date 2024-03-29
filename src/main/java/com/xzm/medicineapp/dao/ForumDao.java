package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.mapper.FoodMapper;
import com.xzm.medicineapp.mapper.ForumMapper;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class ForumDao {

    @Resource
    public ForumMapper forumMapper;

    //得到论坛
    public List<Forum> getForums(PageModel pageModel) {
        return forumMapper.getForums(pageModel);
    }

    //得到论坛
    public Forum getForumById(Integer id) {
        return forumMapper.getForumById(id);
    }

    //添加论坛
    public Integer addForum(Forum forum) {
        return forumMapper.addForum(forum);
    }

    //删除论坛
    public Integer delForumById(Integer id) {
        return forumMapper.delForumById(id);
    }

    public Integer getCount() {
        return forumMapper.getCount();
    }

    public Integer addComments(Integer id) {
        return forumMapper.addComments(id);
    }

    public Integer delComments(Integer id) {
        return forumMapper.delComments(id);
    }

    public List<Forum> getForumByUserName(String name) {
        return forumMapper.getForumByUserName(name);
    }

    public Integer delForumByUserName(String name) {
        return forumMapper.delForumByUserName(name);
    }
}
