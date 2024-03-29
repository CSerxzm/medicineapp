package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.dao.CommentDao;
import com.xzm.medicineapp.dao.ForumDao;
import com.xzm.medicineapp.service.ForumService;
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
@Transactional
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;

    @Autowired
    private CommentDao commentDao;

    //得到论坛
    public List<Forum> getForums(PageModel pageModel) {
        Integer count = forumDao.getCount();
        pageModel.setRecordCount(count);
        return forumDao.getForums(pageModel);
    }

    //得到论坛
    public Forum getForumById(Integer id) {
        return forumDao.getForumById(id);
    }

    //添加论坛
    @Transactional
    public Integer addForum(Forum forum) {
        return forumDao.addForum(forum);
    }

    //删除论坛
    @Transactional
    public Integer delForumById(Integer id) {
        Forum forum = forumDao.getForumById(id);
        commentDao.delCommentsByForumId(forum.getId());
        return forumDao.delForumById(id);
    }

}
