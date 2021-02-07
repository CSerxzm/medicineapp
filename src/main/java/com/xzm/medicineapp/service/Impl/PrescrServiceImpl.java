package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.dao.PrescrDao;
import com.xzm.medicineapp.service.PrescrService;
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
public class PrescrServiceImpl implements PrescrService {

    @Autowired
    private PrescrDao prescrDao;

    public Prescr getPrescrById(Integer id){
        return prescrDao.getPrescrById(id);
    }
    public List<Prescr> getPrescrs(PageModel pageModel){
        Integer count = prescrDao.getCount();
        pageModel.setRecordCount(count);
        return prescrDao.getPrescrs(pageModel);
    }

    @Transactional
    public Integer addPrescr(Prescr prescr){
        return prescrDao.addPrescr(prescr);
    }

    @Transactional
    public Integer delPrescr(Integer id){
        return prescrDao.delPrescr(id);
    }

    @Transactional
    public Integer updatePrescr(Prescr prescr){
        return prescrDao.updatePrescr(prescr);
    }
}
