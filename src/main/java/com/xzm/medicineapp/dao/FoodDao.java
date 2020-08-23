package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Comment;
import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.mapper.CommentMapper;
import com.xzm.medicineapp.mapper.FoodMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class FoodDao {

    @Resource
    public FoodMapper foodMapper;

    public Food getFoodById(Integer id){
        return foodMapper.getFoodById(id);
    }
    public List<Food> getFoods(){
        return foodMapper.getFoods();
    }
    public Integer addFood(Food food){
        return foodMapper.addFood(food);
    }
    public Integer delFood(Integer id){
        return foodMapper.delFood(id);
    }
    public Integer updateFood(Food food){
        return foodMapper.updateFood(food);
    }
}
