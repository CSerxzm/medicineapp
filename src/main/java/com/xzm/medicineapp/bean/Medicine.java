package com.xzm.medicineapp.bean;

/**
 * @author 3052
 * @create 2020-08-22 12:12
 */
public class Medicine {

    private Integer id;
    private String name;
    private String nickname;
    private String image;
    private String funs;
    private String taboos;

    public Medicine(){

    }

    public Medicine(Integer id, String name, String nickname, String image, String funs, String taboos) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.image = image;
        this.funs = funs;
        this.taboos = taboos;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFuns() {
        return funs;
    }

    public void setFuns(String funs) {
        this.funs = funs;
    }

    public String getTaboos() {
        return taboos;
    }

    public void setTaboos(String taboos) {
        this.taboos = taboos;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", image='" + image + '\'' +
                ", funs='" + funs + '\'' +
                ", taboos='" + taboos + '\'' +
                '}';
    }
}
