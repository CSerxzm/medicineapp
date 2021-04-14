package com.xzm.medicineapp.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 3052
 * @create 2020-08-22 12:38
 */
public class Comment {

    private Integer id;
    private Integer forumId;
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date editTime;
    private String content;

    public Comment() {

    }

    public Comment(Integer id, Integer forumId, User user, Date editTime, String content) {
        this.id = id;
        this.forumId = forumId;
        this.user = user;
        this.editTime = editTime;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", forumId=" + forumId +
                ", user=" + user +
                ", editTime=" + editTime +
                ", content='" + content + '\'' +
                '}';
    }
}
