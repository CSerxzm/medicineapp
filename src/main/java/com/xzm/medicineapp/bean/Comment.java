package com.xzm.medicineapp.bean;

import java.util.Date;

/**
 * @author 3052
 * @create 2020-08-22 12:38
 */
public class Comment {

    private Integer id;
    private Integer forum_id;
    private String name;
    private Date edit_time;
    private String content;

    public Comment(){

    }
    public Comment(Integer id, Integer forum_id, String name, Date edit_time, String content) {
        this.id = id;
        this.forum_id = forum_id;
        this.name = name;
        this.edit_time = edit_time;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getForum_id() {
        return forum_id;
    }

    public void setForum_id(Integer forum_id) {
        this.forum_id = forum_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEdit_time() {
        return edit_time;
    }

    public void setEdit_time(Date edit_time) {
        this.edit_time = edit_time;
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
                ", forum_id=" + forum_id +
                ", name='" + name + '\'' +
                ", edit_time=" + edit_time +
                ", content='" + content + '\'' +
                '}';
    }
}
