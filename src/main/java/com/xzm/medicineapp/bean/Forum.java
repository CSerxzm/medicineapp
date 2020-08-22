package com.xzm.medicineapp.bean;

import java.util.Date;

/**
 * @author 3052
 * @create 2020-08-22 12:32
 */
public class Forum {

    private Integer id;
    private String name;
    private Date edit_time;
    private String content;
    private String keyword;
    private Integer views;
    private Integer comments;

    public Forum(){

    }

    public Forum(Integer id, String name, Date edit_time, String content, String keyword, Integer views, Integer comments) {
        this.id = id;
        this.name = name;
        this.edit_time = edit_time;
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
                ", name='" + name + '\'' +
                ", edit_time=" + edit_time +
                ", content='" + content + '\'' +
                ", keyword='" + keyword + '\'' +
                ", views=" + views +
                ", comments=" + comments +
                '}';
    }
}
