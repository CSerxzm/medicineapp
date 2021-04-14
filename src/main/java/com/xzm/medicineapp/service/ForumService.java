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

public interface ForumService {

    List<Forum> getForums(PageModel pageModel);

    //得到论坛
    Forum getForumById(Integer id);

    //添加论坛
    Integer addForum(Forum forum);

    //删除论坛
    Integer delForumById(Integer id);

}
