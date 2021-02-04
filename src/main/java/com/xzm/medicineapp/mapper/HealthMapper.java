package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.util.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface HealthMapper {

    Health getHealthById(Integer id);
    List<Health> getHealthsByType(@Param("main_type") Integer main_type,@Param("sub_type") Integer sub_type);
    List<Health> getHealths(PageModel pageModel);
    Integer addHealth(Health health);
    Integer delHealth(Integer id);
    Integer updateHealth(Health health);
    Integer getCount();

}
