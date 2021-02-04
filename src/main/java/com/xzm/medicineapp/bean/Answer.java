package com.xzm.medicineapp.bean;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 17:43
 */
public class Answer {

    private String type;
    private String name;
    private Integer value;

    public Answer() {
    }

    public Answer(String name, Integer value) {
        this.name = name;
        this.value = value;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
