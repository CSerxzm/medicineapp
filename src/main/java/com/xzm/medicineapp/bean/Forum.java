package com.xzm.medicineapp.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 3052
 * @create 2020-08-22 12:32
 */
public class Forum {

    private Integer id;
    private User user;//发布者名字
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date editTime;
    private String content;
    private String keyword;
    private Integer comments;

    public Forum(){

    }

    public Forum(Integer id, User user,String content, String keyword, Integer views, Integer comments) {
        this.id = id;
        this.user = user;
        this.editTime = new Date();
        this.content = content;
        this.keyword = keyword;
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
                ", comments=" + comments +
                '}';
    }
}
