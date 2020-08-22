package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Rumor;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface RumorMapper {

    public Rumor getRumorById(Integer id);
    public List<Rumor> getRumors();

}
