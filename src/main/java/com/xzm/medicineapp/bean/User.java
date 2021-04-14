package com.xzm.medicineapp.bean;

import java.io.Serializable;

/**
 * @author 3052
 * @create 2020-08-21 21:07
 */
public class User implements Serializable {

    private String name;
    private String password;
    private String image;
    private Integer sex;//性别,0为女，1为男
    private String constellation;//星座
    private String phone;//电话
    private String email;//邮箱
    private String authority;

    public User(String name, String password, String image, String authority) {
        this.name = name;
        this.password = password;
        this.image = image;
        this.authority = authority;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
