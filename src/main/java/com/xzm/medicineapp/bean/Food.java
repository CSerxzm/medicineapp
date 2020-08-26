package com.xzm.medicineapp.bean;

/**
 * @author 3052
 * @create 2020-08-22 12:24
 */
public class Food {

    private Integer id;
    private String name;
    private String image;
    private String compose;
    private String method;
    private String funs;

    public Food(){

    }

    public Food(Integer id, String name, String image, String compose, String method, String funs) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.compose = compose;
        this.method = method;
        this.funs = funs;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompose() {
        return compose;
    }

    public void setCompose(String compose) {
        this.compose = compose;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFuns() {
        return funs;
    }

    public void setFuns(String funs) {
        this.funs = funs;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", compose='" + compose + '\'' +
                ", method='" + method + '\'' +
                ", funs='" + funs + '\'' +
                '}';
    }
}
