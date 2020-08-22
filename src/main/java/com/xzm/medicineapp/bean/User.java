package com.xzm.medicineapp.bean;

import java.io.Serializable;

/**
 * @author 3052
 * @create 2020-08-21 21:07
 */
public class User implements Serializable{

    private String name;
    private String password;
    private String image;
    private String authority;

    public User(String name, String password, String image, String authority) {
        this.name = name;
        this.password = password;
        this.image = image;
        this.authority = authority;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
