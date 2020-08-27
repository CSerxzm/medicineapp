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

    public Prescr getPrescrById(Integer id);
    public List<Prescr> getPrescrs(PageModel pageModel);
    public Integer addPrescr(Prescr prescr);
    public Integer delPrescr(Integer id);
    public Integer updatePrescr(Prescr prescr);
    public Integer getCount();

}
