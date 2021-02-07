package com.xzm.medicineapp.bean;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-06 21:52
 */
public class Constellation {

    private String name;

    private String date;

    private String health;

    private String love;

    private String work;

    private String money;

    private String summary;

    private Long ttl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "Constellation{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", health='" + health + '\'' +
                ", love='" + love + '\'' +
                ", work='" + work + '\'' +
                ", money='" + money + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
