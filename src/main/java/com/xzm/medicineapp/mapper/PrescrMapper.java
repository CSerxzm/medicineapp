package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface PrescrMapper {

    Prescr getPrescrById(Integer id);
    List<Prescr> getPrescrs(PageModel pageModel);
    Integer addPrescr(Prescr prescr);
    Integer delPrescr(Integer id);
    Integer updatePrescr(Prescr prescr);
    Integer getCount();

}
