package com.xzm.medicineapp.bean;

import java.util.Date;

/**
 * @author 3052
 * @create 2020-08-22 12:38
 */
public class Comment {

    private Integer id;
    private Integer forumId;
    private String name;
    private Date editTime;
    private String content;

    public Comment(){

    }

    public Comment(Integer id, Integer forumId, String name, Date editTime, String content) {
        this.id = id;
        this.forumId = forumId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", editTime=" + editTime +
                ", content='" + content + '\'' +
                '}';
    }
}
