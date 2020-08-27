package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.mapper.HealthMapper;
import com.xzm.medicineapp.mapper.UserMapper;
import com.xzm.medicineapp.util.PageModel;
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

    public List<Health> getHealthsByType(Integer mainType,Integer subType){
        return healthMapper.getHealthsByType(mainType,subType);
    }

    public List<Health> getHealths(PageModel pageModel){
        return healthMapper.getHealths(pageModel);
    }
    public Integer addHealth(Health health){
        return healthMapper.addHealth(health);
    }
    public Integer delHealth(Integer id){
        return healthMapper.delHealth(id);
    }
    public Integer updateHealth(Health health){
        return healthMapper.updateHealth(health);
    }
    public Integer getCount(){
        return healthMapper.getCount();
    }
}
