package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.dao.HealthDao;
import com.xzm.medicineapp.dao.PrescrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class PrescrService {

    @Autowired
    private PrescrDao prescrDao;

    public Prescr getPrescrById(Integer id){
        return prescrDao.getPrescrById(id);
    }
    public List<Prescr> getPrescrs(){
        return prescrDao.getPrescrs();
    }
}