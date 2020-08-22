package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Food;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface FoodMapper {

    public Food getFoodById(Integer id);
    public List<Food> getFoods();

}
