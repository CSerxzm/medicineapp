package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.dao.HealthDao;
import com.xzm.medicineapp.dao.UserDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */

public interface HealthService {

    Health getHealthById(Integer id);

    List<Health> getHealthsByType(Integer mainType, Integer subType);

    List<Health> getHealths(PageModel pageModel);

    Integer addHealth(Health health);

    Integer delHealth(Integer id);

    Integer updateHealth(Health health);

}
