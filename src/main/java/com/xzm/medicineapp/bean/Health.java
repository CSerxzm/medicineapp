package com.xzm.medicineapp.bean;

/**
 * @author 3052
 * @create 2020-08-22 12:08
 */
public class Health {

    private Integer id;
    private String title;
    private String autho;
    private String edit_time;
    private String content;
    private String main_type;
    private String sub_typ;
    Integer views;

    public Health(){

    }

    public Health(Integer id, String title, String autho, String edit_time, String content, String main_type, String sub_typ, Integer views) {
        this.id = id;
        this.title = title;
        this.autho = autho;
        this.edit_time = edit_time;
        this.content = content;
        this.main_type = main_type;
        this.sub_typ = sub_typ;
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

    public String getAutho() {
        return autho;
    }

    public void setAutho(String autho) {
        this.autho = autho;
    }

    public String getEdit_time() {
        return edit_time;
    }

    public void setEdit_time(String edit_time) {
        this.edit_time = edit_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMain_type() {
        return main_type;
    }

    public void setMain_type(String main_type) {
        this.main_type = main_type;
    }

    public String getSub_typ() {
        return sub_typ;
    }

    public void setSub_typ(String sub_typ) {
        this.sub_typ = sub_typ;
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
                ", autho='" + autho + '\'' +
                ", edit_time='" + edit_time + '\'' +
                ", content='" + content + '\'' +
                ", main_type='" + main_type + '\'' +
                ", sub_typ='" + sub_typ + '\'' +
                ", views=" + views +
                '}';
    }
}
