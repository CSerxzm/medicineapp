package com.xzm.medicineapp.bean;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-03 21:03
 */
public class TestPaper {

    private Integer id;

    private String type;

    private String name;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public TestPaper(){

    }

    public TestPaper(String type, String name) {
        this.type = type;
        this.name = name;
        this.createTime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
