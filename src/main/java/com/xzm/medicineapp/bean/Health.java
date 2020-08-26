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
    private String image;
    private String content;
    private Integer mainType;
    private Integer subType;
    private Integer views;

    public Health() {

    }

    public Health(Integer id, String title, String author, String editTime, String image, String content, Integer mainType, Integer subType, Integer views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editTime = editTime;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMainType() {
        return mainType;
    }

    public void setMainType(Integer mainType) {
        this.mainType = mainType;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
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
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", mainType=" + mainType +
                ", subType=" + subType +
                ", views=" + views +
                '}';
    }
}
