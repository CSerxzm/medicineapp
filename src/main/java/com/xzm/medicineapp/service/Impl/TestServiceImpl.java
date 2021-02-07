package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Answer;
import com.xzm.medicineapp.bean.TestPaper;
import com.xzm.medicineapp.bean.TestQuestion;
import com.xzm.medicineapp.bean.TestResult;
import com.xzm.medicineapp.dao.TestDao;
import com.xzm.medicineapp.service.TestService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 17:31
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public List<TestQuestion> selectQuestionByType(String type) {
        List<TestQuestion> testQuestions = testDao.selectQuestionByType(type);
        for(TestQuestion testQuestion:testQuestions){
            String[] split = testQuestion.getAnswer().split(";");
            List<Answer> answerList = new ArrayList<>();
            for(int i=0;i<split.length;i++){
                answerList.add(new Answer(split[i],i+1));
            }
            testQuestion.setAnswerList(answerList);
        }
        return testQuestions;
    }

    @Override
    public TestResult selectResultById(Integer id) {
        return testDao.selectResultById(id);
    }

    @Override
    public TestResult selectResultByType(List<Answer> answerList,String name) {
        int sum=0;
        for(Answer answer:answerList){
            sum+=answer.getValue();
        }
        String type = answerList.get(0).getType();
        TestResult testResult = testDao.selectResultByType(type);
        testResult.setViews(testResult.getViews()==null?1:testResult.getViews()+1);
        //只是更新views
        testDao.updateTestResult(testResult);
        if(sum<testResult.getSureThreshold() && sum>=testResult.getTendThreshold()){
            testDao.addTestPaper( new TestPaper(type,name));
            testResult.setType("倾向于"+testResult.getType());
        }else if(sum<testResult.getTendThreshold()){
            testResult.setType("你不属于"+testResult.getType());
        }else{
            testDao.addTestPaper( new TestPaper(type,name));
        }
        return testResult;
    }

    @Override
    public List<TestResult> selectAllType() {
        return testDao.selectAllType();
    }

    @Override
    public List<TestPaper> selectPaperByUser(PageModel pageModel, String name) {
        Integer count = testDao.getCount(name);
        pageModel.setRecordCount(count);
        return testDao.selectPaperByUser(pageModel,name);
    }

    @Override
    public TestResult selectResultByType(String name) {
        return testDao.selectResultByType(name);
    }

    @Override
    public List<TestPaper> getTestPapers(PageModel pageModel){
        Integer count = testDao.getCount(null);
        pageModel.setRecordCount(count);
        return testDao.getTestPapers(pageModel);
    }

    @Override
    @Transactional
    public Integer delTestPaper(Integer id) {
        return testDao.delTestPaper(id);
    }

    @Override
    public List<TestResult> selectTestResults() {
        return testDao.selectTestResults();
    }

    @Override
    @Transactional
    public Integer updateTestResult(TestResult testResult) {
        return testDao.updateTestResult(testResult);
    }
}
