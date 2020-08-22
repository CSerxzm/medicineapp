package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:19
 */
@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;
    @ResponseBody
    @RequestMapping("/getFoodById")
    public String getFoodById(Integer id){
        Food food = foodService.getFoodById(id);
        return JSON.toJSONString(food);
    }
    @ResponseBody
    @RequestMapping("/getFoods")
    public String getFoods(){
        List<Food> foodList=foodService.getFoods();
        return JSON.toJSONString(foodList);
    }

}
