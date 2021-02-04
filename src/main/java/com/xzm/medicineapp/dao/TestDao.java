package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.TestPaper;
import com.xzm.medicineapp.bean.TestQuestion;
import com.xzm.medicineapp.bean.TestResult;
import com.xzm.medicineapp.mapper.TestPaperMapper;
import com.xzm.medicineapp.mapper.TestQuestionMapper;
import com.xzm.medicineapp.mapper.TestResultMapper;
import com.xzm.medicineapp.util.PageModel;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 17:03
 */

@Repository
public class TestDao {

    @Autowired
    TestQuestionMapper testQuestionMapper;

    @Autowired
    TestResultMapper testResultMapper;

    @Autowired
    TestPaperMapper testPaperMapper;

    public List<TestQuestion> selectQuestionByType(String type){
        return testQuestionMapper.selectQuestionByType(type);
    }

    public TestResult selectResultByType(String type){
        return testResultMapper.selectResultByType(type);
    }

    public List<TestResult> selectAllType(){
        return testResultMapper.selectAllType();
    }

    public Integer updateTestResult(TestResult testResult){
        return testResultMapper.updateTestResult(testResult);
    }

    public Integer addTestPaper(TestPaper testPaper){
        return testPaperMapper.addTestPaper(testPaper);
    }

    public List<TestPaper> selectPaperByUser(PageModel pageModel, String name){
        return testPaperMapper.selectPaperByUser(pageModel.getFirstLimitParam(),
                pageModel.getPageSize(),name);
    }

    public Integer getCount(String name){
        return testPaperMapper.getCount(name);
    }
}
