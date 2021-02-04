package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzm.medicineapp.bean.Answer;
import com.xzm.medicineapp.bean.TestPaper;
import com.xzm.medicineapp.bean.TestQuestion;
import com.xzm.medicineapp.bean.TestResult;
import com.xzm.medicineapp.service.TestService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 17:35
 */
@Controller
public class TestController {

    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping("/getquestion")
    public List<TestQuestion> getQuestion(String type){
        List<TestQuestion> questions = testService.selectQuestionByType(type);
        return questions;
    }

    @ResponseBody
    @RequestMapping("/postquestion")
    public TestResult postQuestion(@RequestBody String answerList){
        JSONObject obj=JSONObject.parseObject(answerList);
        JSONArray arr = obj.getJSONArray("answerList");
        String name = obj.getString("name");
        List<Answer> taskNodes = JSONArray.parseArray(arr.toJSONString(),Answer.class);
        return testService.selectResultByType(taskNodes,name);
    }

    @ResponseBody
    @RequestMapping("/getquestiontype")
    public List<TestResult> getQuestiontype(){
        return testService.selectAllType();
    }

    @ResponseBody
    @RequestMapping("/getpaperbyuser")
    public String getPaperByUser(PageModel pageModel, String name){
        List<TestPaper> paperList = testService.selectPaperByUser(pageModel,name);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",paperList);
        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping("/selectresultbytype")
    public TestResult selectResultByType(String type){
        return testService.selectResultByType(type);
    }
}
