package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Answer;
import com.xzm.medicineapp.bean.TestPaper;
import com.xzm.medicineapp.bean.TestQuestion;
import com.xzm.medicineapp.bean.TestResult;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 17:31
 */
public interface TestService {

    List<TestQuestion> selectQuestionByType(String type);

    TestResult selectResultByType(List<Answer> answerList,String name);

    List<TestResult> selectAllType();


    /**
     * 获得用户的测试记录
     * @param pageModel
     * @param name
     * @return
     */
    List<TestPaper> selectPaperByUser(PageModel pageModel, String name);

    /**
     * 通过类型获得相关的建议
     * @param name
     * @return
     */
    TestResult selectResultByType(String name);
}
