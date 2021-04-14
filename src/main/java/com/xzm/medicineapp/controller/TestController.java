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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public List<TestQuestion> getQuestion(String type) {
        List<TestQuestion> questions = testService.selectQuestionByType(type);
        return questions;
    }

    @ResponseBody
    @RequestMapping("/postquestion")
    public TestResult postQuestion(@RequestBody String answerList) {
        JSONObject obj = JSONObject.parseObject(answerList);
        JSONArray arr = obj.getJSONArray("answerList");
        String name = obj.getString("name");
        List<Answer> taskNodes = JSONArray.parseArray(arr.toJSONString(), Answer.class);
        return testService.selectResultByType(taskNodes, name);
    }

    @ResponseBody
    @RequestMapping("/getquestiontype")
    public List<TestResult> getQuestiontype() {
        return testService.selectAllType();
    }

    @ResponseBody
    @RequestMapping("/getpaperbyuser")
    public String getPaperByUser(PageModel pageModel, String name) {
        List<TestPaper> paperList = testService.selectPaperByUser(pageModel, name);
        Map<String, Object> map = new HashMap();
        map.put("page", pageModel);
        map.put("data", paperList);
        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping("/selectresultbytype")
    public TestResult selectResultByType(String type) {
        return testService.selectResultByType(type);
    }

    /*************************后台管理*************************/
    /**
     * 获得所有的测试记录
     *
     * @param modelMap
     * @param pageModel
     * @return
     */
    @GetMapping("/back/testpapers")
    public String backTestPapers(ModelMap modelMap, PageModel pageModel) {
        List<TestPaper> testPapers = testService.getTestPapers(pageModel);
        modelMap.addAttribute("testpapers", testPapers);
        modelMap.addAttribute("pagemodel", pageModel);
        return "testpaper/list";
    }

    /**
     * 删除测试记录
     *
     * @param id
     * @return
     */
    @DeleteMapping("/back/testpaper/{id}")
    public String deleteTestPaper(@PathVariable("id") Integer id) {
        testService.delTestPaper(id);
        return "redirect:/back/testpaper";
    }

    /**
     * 获得所有体质的建议
     *
     * @param modelMap
     * @return
     */
    @GetMapping("/back/testresults")
    public String backTestResults(ModelMap modelMap) {
        List<TestResult> testResults = testService.selectTestResults();
        modelMap.addAttribute("testresults", testResults);
        return "testresult/list";
    }

    /**
     * 获得体质建议
     *
     * @param id
     * @param modelMap
     * @return
     */
    @GetMapping("/back/resultinfo/{id}")
    public String toInfoPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        TestResult testResult = testService.selectResultById(id);
        modelMap.addAttribute("testresult", testResult);
        return "testresult/info";
    }

    @GetMapping("/back/testresult/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        TestResult testResult = testService.selectResultById(id);
        modelMap.addAttribute("testresult", testResult);
        return "testresult/edit";
    }

    @PutMapping("/back/testresult")
    public String updateTestResult(TestResult testResult) {
        testService.updateTestResult(testResult);
        return "redirect:/back/testresults";
    }

}
