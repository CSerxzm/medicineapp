package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.dao.FoodDao;
import com.xzm.medicineapp.dao.HealthDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */

public interface FoodService {

    Food getFoodById(Integer id);
    List<Food> getFoods(PageModel pageModel);
    Integer addFood(Food food);
    Integer delFood(Integer id);
    Integer updateFood(Food food);

}
