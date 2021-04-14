package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.dao.HealthDao;
import com.xzm.medicineapp.service.HealthService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
@Transactional
public class HealthServiceImpl implements HealthService {

    @Autowired
    private HealthDao healthDao;

    public Health getHealthById(Integer id) {
        Health result = healthDao.getOneById(id);
        return result;
    }

    public List<Health> getHealthsByType(Integer mainType, Integer subType) {
        return healthDao.getHealthsByType(mainType, subType);
    }

    public List<Health> getHealths(PageModel pageModel) {
        Integer count = healthDao.getCount();
        pageModel.setRecordCount(count);
        return healthDao.getHealths(pageModel);
    }

    @Transactional
    public Integer addHealth(Health health) {
        return healthDao.addHealth(health);
    }

    @Transactional
    public Integer delHealth(Integer id) {
        return healthDao.delHealth(id);
    }

    @Transactional
    public Integer updateHealth(Health health) {
        return healthDao.updateHealth(health);
    }
}
