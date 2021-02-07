package com.xzm.medicineapp.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 14:27
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestResult {

    private Integer id;

    private String type;

    private Integer sureThreshold;

    private Integer tendThreshold;

    private String feature;

    private String reason;

    private String attack;

    private String healthPrinciple;

    private String dailyCare;

    private String foodCare;

    private String medicineCare;

    private String spiritCare;

    private Integer views;

    public TestResult() {
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

    public Integer getSureThreshold() {
        return sureThreshold;
    }

    public void setSureThreshold(Integer sureThreshold) {
        this.sureThreshold = sureThreshold;
    }

    public Integer getTendThreshold() {
        return tendThreshold;
    }

    public void setTendThreshold(Integer tendThreshold) {
        this.tendThreshold = tendThreshold;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getHealthPrinciple() {
        return healthPrinciple;
    }

    public void setHealthPrinciple(String healthPrinciple) {
        this.healthPrinciple = healthPrinciple;
    }

    public String getDailyCare() {
        return dailyCare;
    }

    public void setDailyCare(String dailyCare) {
        this.dailyCare = dailyCare;
    }

    public String getFoodCare() {
        return foodCare;
    }

    public void setFoodCare(String foodCare) {
        this.foodCare = foodCare;
    }

    public String getMedicineCare() {
        return medicineCare;
    }

    public void setMedicineCare(String medicineCare) {
        this.medicineCare = medicineCare;
    }

    public String getSpiritCare() {
        return spiritCare;
    }

    public void setSpiritCare(String spiritCare) {
        this.spiritCare = spiritCare;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
