package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.dao.FoodDao;
import com.xzm.medicineapp.service.FoodService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service

public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    public Food getFoodById(Integer id) {
        return foodDao.getFoodById(id);
    }

    public List<Food> getFoods(PageModel pageModel) {
        Integer count = foodDao.getCount();
        pageModel.setRecordCount(count);
        return foodDao.getFoods(pageModel);
    }

    @Transactional
    public Integer addFood(Food food) {
        return foodDao.addFood(food);
    }

    @Transactional
    public Integer delFood(Integer id) {
        return foodDao.delFood(id);
    }

    @Transactional
    public Integer updateFood(Food food) {
        return foodDao.updateFood(food);
    }
}
