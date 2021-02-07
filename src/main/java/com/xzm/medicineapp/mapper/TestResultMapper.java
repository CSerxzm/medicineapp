package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.TestQuestion;
import com.xzm.medicineapp.bean.TestResult;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 16:42
 */
public interface TestResultMapper {

    TestResult selectResultById(Integer id);

    TestResult selectResultByType(String type);

    List<TestResult> selectAllType();

    Integer updateTestResult(TestResult testResult);

    List<TestResult> selectTestResults();

}
