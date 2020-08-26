package com.xzm.medicineapp.bean;

/**
 * @author 3052
 * @create 2020-08-22 12:20
 */
public class Rumor {

    private Integer id;
    private String title;
    private String image;
    private String content;
    private String source;
    private String reality;

    public Rumor(){

    }

    public Rumor(Integer id, String title,String image, String content, String source, String reality) {
        this.id = id;
        this.title = title;
        this.image=image;
        this.content = content;
        this.source = source;
        this.reality = reality;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReality() {
        return reality;
    }

    public void setReality(String reality) {
        this.reality = reality;
    }

    @Override
    public String toString() {
        return "Rumor{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", reality='" + reality + '\'' +
                '}';
    }
}
