package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.dao.HealthDao;
import com.xzm.medicineapp.dao.PrescrDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */

public interface PrescrService {

    Prescr getPrescrById(Integer id);
    List<Prescr> getPrescrs(PageModel pageModel);
    Integer addPrescr(Prescr prescr);
    Integer delPrescr(Integer id);
    Integer updatePrescr(Prescr prescr);

}
