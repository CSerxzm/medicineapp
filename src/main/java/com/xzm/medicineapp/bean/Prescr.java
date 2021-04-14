package com.xzm.medicineapp.bean;

import javax.print.DocFlavor;

/**
 * @author 3052
 * @create 2020-08-22 12:16
 */
public class Prescr {

    private Integer id;
    private String name;
    private String compose;
    private String funs;
    private String source;

    public Prescr() {

    }

    public Prescr(Integer id, String name, String compose, String funs, String source) {
        this.id = id;
        this.name = name;
        this.compose = compose;
        this.funs = funs;
        this.source = source;
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

    public String getCompose() {
        return compose;
    }

    public void setCompose(String compose) {
        this.compose = compose;
    }

    public String getFuns() {
        return funs;
    }

    public void setFuns(String funs) {
        this.funs = funs;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Prescr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", compose='" + compose + '\'' +
                ", funs='" + funs + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
