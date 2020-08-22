package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.dao.FoodDao;
import com.xzm.medicineapp.dao.HealthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;

    public Food getFoodById(Integer id){
        return  foodDao.getFoodById(id);
    }
    public List<Food> getFoods(){
        return foodDao.getFoods();
    }
}
