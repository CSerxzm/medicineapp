package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.dao.FoodDao;
import com.xzm.medicineapp.dao.ForumDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class ForumService {

    @Autowired
    private ForumDao forumDao;

    //得到论坛
    public List<Forum> getForums(PageModel pageModel){
        Integer count = forumDao.getCount();
        pageModel.setRecordCount(count);
        return forumDao.getForums(pageModel);
    }
    //得到论坛
    public Forum getForumById(Integer id){
        return forumDao.getForumById(id);
    }
    //添加论坛
    public Integer addForum(Forum forum){
        return forumDao.addForum(forum);
    }
    //删除论坛
    public Integer delForumById(Integer id){
        return forumDao.delForumById(id);
    }
}
