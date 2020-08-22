package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.mapper.HealthMapper;
import com.xzm.medicineapp.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class HealthDao {

    @Resource
    public HealthMapper healthMapper;

    public Health getOneById(Integer id){
        return healthMapper.getHealthById(id);
    }

    public List<Health> getHealthsByType(String main_type,String sub_type){
        return healthMapper.getHealthsByType(main_type,sub_type);
    }

    public List<Health> getHealths(){
        return healthMapper.getHealths();
    }
}
