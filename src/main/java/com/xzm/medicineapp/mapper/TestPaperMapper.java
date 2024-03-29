package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.TestPaper;
import com.xzm.medicineapp.bean.TestResult;
import com.xzm.medicineapp.util.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-02 16:42
 */
public interface TestPaperMapper {

    /**
     * 获得用户的测试记录
     *
     * @param firstLimitParam
     * @param pageSize
     * @param name
     * @return
     */
    List<TestPaper> selectPaperByUser(@Param("firstLimitParam") Integer firstLimitParam,
                                      @Param("pageSize") Integer pageSize,
                                      @Param("name") String name);

    /**
     * 添加用户测试记录
     *
     * @param testPaper
     * @return
     */
    Integer addTestPaper(TestPaper testPaper);

    /**
     * 获得测试记录总数
     *
     * @param name
     * @return
     */
    Integer getCount(String name);

    /**
     * 获得测试记录
     *
     * @param pageModel
     * @return
     */
    List<TestPaper> getTestPapers(PageModel pageModel);

    /**
     * 删除测试结果
     *
     * @param id
     * @return
     */
    Integer delTestPaper(Integer id);

    /**
     * 删除用户的测试记录
     *
     * @param name
     * @return
     */
    Integer delTestPaperByName(String name);

}
