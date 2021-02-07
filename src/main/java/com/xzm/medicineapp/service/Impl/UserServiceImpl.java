package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.dao.CommentDao;
import com.xzm.medicineapp.dao.ForumDao;
import com.xzm.medicineapp.dao.TestDao;
import com.xzm.medicineapp.dao.UserDao;
import com.xzm.medicineapp.service.UserService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ForumDao forumDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    TestDao testDao;

    /**
     * 登录用户
     * @param user
     * @return
     */
    public User login(User user){
        String pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pass);
        User result = userDao.getUser(user);
        return result;
    }

    /**
     * 分页得到所有的用户
     * @param pageModel
     * @return
     */
    public List<User> getUsers(PageModel pageModel){
        Integer count = userDao.getCount();
        pageModel.setRecordCount(count);
        return userDao.getUsers(pageModel);
    }

    public Integer addUser(User user){
        return userDao.addUser(user);
    }

    /**
     * 删除用户
     * @param name
     * @return
     */
    @Transactional
    public Integer delUser(String name){
        //删除用户发表的评论
        List<Comment> comments = commentDao.getCommentsByUserName(name);
        for(Comment comment:comments){
            //降低评论数
            forumDao.delComments(comment.getForumId());
        }
        commentDao.delCommentsByUserName(name);
        //删除用户发表的论坛
        List<Forum> forums = forumDao.getForumByUserName(name);
        for(Forum forum :forums){
            commentDao.delCommentsByForumId(forum.getId());
        }
        forumDao.delForumByUserName(name);
        //删除用户的测试记录
        testDao.delPaperByUser(name);
        return userDao.delUser(name);
    }

    @Transactional
    public Integer updateUser(User user){
        return userDao.updateUser(user);
    }

    /**
     * 得到用户名
     * @param name
     * @return
     */
    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Transactional
    public Integer registUser(User user){
        User userByName = userDao.getUserByName(user.getName());
        if(userByName!=null){
            return 0;
        }
        String pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pass);
        return userDao.registUser(user);
    }

    /**
     * 保存用户的相关信息，除了用户密码和权限
     * @param user
     * @return
     */
    @Transactional
    public User updateUserWithoutPassAndAuthority(User user){
        userDao.updateUserWithoutPassAndAuthority(user);
        User userByName = userDao.getUserByName(user.getName());
        return  userByName;
    }

    /**
     * 更新用户密码
     * @param user
     * @param oldPass
     * @return
     */
    @Transactional
    public User updateUserPass(User user,String oldPass){
        User userByName = userDao.getUserByName(user.getName());
        String pass = DigestUtils.md5DigestAsHex(oldPass.getBytes());
        if(!userByName.getPassword().equals(pass)){
            //密码错误，原有的
            return null;
        }
        String newPass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(newPass);
        userDao.updateUserPass(user);
        return userDao.getUser(user);
    }
}
