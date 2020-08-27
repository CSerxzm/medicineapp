package com.xzm.medicineapp.bean;

import java.util.Date;

/**
 * @author 3052
 * @create 2020-08-22 12:32
 */
public class Forum {

    private Integer id;
    private User user;//发布者名字
    private Date editTime;
    private String content;
    private String keyword;
    private Integer views;
    private Integer comments;

    public Forum(){

    }

    public Forum(Integer id, User user, Date editTime, String content, String keyword, Integer views, Integer comments) {
        this.id = id;
        this.user = user;
        this.editTime = editTime;
        this.content = content;
        this.keyword = keyword;
        this.views = views;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", user=" + user +
                ", editTime=" + editTime +
                ", content='" + content + '\'' +
                ", keyword='" + keyword + '\'' +
                ", views=" + views +
                ", comments=" + comments +
                '}';
    }
}
