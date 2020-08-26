package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.dao.HealthDao;
import com.xzm.medicineapp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class HealthService {

    @Autowired
    private HealthDao healthDao;

    public Health getHealthById(Integer id){
        Health result = healthDao.getOneById(id);
        return result;
    }

    public List<Health> getHealthsByType(Integer mainType,Integer subType){
        return healthDao.getHealthsByType(mainType,subType);
    }

    public List<Health> getHealths(){
        return healthDao.getHealths();
    }

    public Integer addHealth(Health health){
        return healthDao.addHealth(health);
    }
    public Integer delHealth(Integer id){
        return healthDao.delHealth(id);
    }
    public Integer updateHealth(Health health){
        return healthDao.updateHealth(health);
    }
}
