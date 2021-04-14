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

    Rumor getRumorById(Integer id);

    List<Rumor> getRumors(PageModel pageModel);

    Integer addRumor(Rumor rumor);

    Integer delRumor(Integer id);

    Integer updateRumor(Rumor rumor);

    Integer getCount();

}
