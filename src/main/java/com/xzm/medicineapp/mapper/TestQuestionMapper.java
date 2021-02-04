package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.TestQuestion;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 16:41
 */
public interface TestQuestionMapper {

    List<TestQuestion> selectQuestionByType(String type);

}
