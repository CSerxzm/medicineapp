package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface FoodMapper {

    Food getFoodById(Integer id);

    List<Food> getFoods(PageModel pageModel);

    public Integer addFood(Food food);

    public Integer delFood(Integer id);

    public Integer updateFood(Food food);

    public Integer getCount();
}
