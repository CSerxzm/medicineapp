package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Health;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface HealthMapper {

    public Health getHealthById(Integer id);
    public List<Health> getHealthsByType(@Param("main_type") String main_type,@Param("sub_type") String sub_type);
    public List<Health> getHealths();

}
