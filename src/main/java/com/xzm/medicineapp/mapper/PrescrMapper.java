package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Prescr;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface PrescrMapper {

    public Prescr getPrescrById(Integer id);
    public List<Prescr> getPrescrs();

}
