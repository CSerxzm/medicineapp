package com.xzm.medicineapp.bean;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 14:27
 */

public class TestQuestion {

    private Integer id;

    private String question;

    private String type;

    private String answer;

    private List<Answer> answerList;

    public TestQuestion(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
