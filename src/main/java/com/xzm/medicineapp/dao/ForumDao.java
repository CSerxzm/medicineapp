package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.mapper.FoodMapper;
import com.xzm.medicineapp.mapper.ForumMapper;
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
    public List<Forum> getForums(){
        return forumMapper.getForums();
    }
    //得到论坛
    public Forum getForumById(Integer id){
        return forumMapper.getForumById(id);
    }
    //添加论坛
    public Integer addForum(Forum forum){
        return forumMapper.addForum(forum);
    }
    //删除论坛
    public Integer delForumById(Integer id){
        return forumMapper.delForumById(id);
    }
}
