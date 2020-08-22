package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.dao.RumorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class RumorService {

    @Autowired
    private RumorDao rumorDao;

    public Rumor getRumorById(Integer id){
        return rumorDao.getRumorById(id);
    }
    public List<Rumor> getRumors(){
        return rumorDao.getRumors();
    }
}
