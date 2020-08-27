package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface RumorMapper {

    public Rumor getRumorById(Integer id);
    public List<Rumor> getRumors(PageModel pageModel);
    public Integer addRumor(Rumor rumor);
    public Integer delRumor(Integer id);
    public Integer updateRumor(Rumor rumor);
    public Integer getCount();

}
