package com.xzm.medicineapp.bean;

/**
 * @author 3052
 * @create 2020-08-22 12:08
 */
public class Health {

    private Integer id;
    private String title;
    private String author;
    private String editTime;
    private String content;
    private String mainType;
    private String subType;
    Integer views;

    public Health() {

    }

    public Health(Integer id, String title, String author, String editTime, String content, String mainType, String subType, Integer views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editTime = editTime;
        this.content = content;
        this.mainType = mainType;
        this.subType = subType;
        this.views = views;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Health{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editTime='" + editTime + '\'' +
                ", content='" + content + '\'' +
                ", mainType='" + mainType + '\'' +
                ", subType='" + subType + '\'' +
                ", views=" + views +
                '}';
    }
}
