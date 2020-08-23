package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
    @RequestMapping("/getfoodbyid")
    public String getFoodById(Integer id){
        Food food = foodService.getFoodById(id);
        return JSON.toJSONString(food);
    }
    @ResponseBody
    @RequestMapping("/getfoods")
    public String getFoods(){
        List<Food> foodList=foodService.getFoods();
        return JSON.toJSONString(foodList);
    }
    /*************************后台管理*************************/

    @GetMapping("/back/foods")
    public String backFoods(ModelMap modelMap){
        Collection<Food> foods = foodService.getFoods();
        modelMap.addAttribute("foods",foods);
        return "food/list";
    }

    @GetMapping("/back/food")
    public String toAddPage(){
        return "food/add";
    }

    @PostMapping("/back/food")
    public String addFood(Food food){
        foodService.addFood(food);
        return "redirect:/back/foods";
    }

    @GetMapping("/back/food/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap){
        Food food = foodService.getFoodById(id);
        modelMap.addAttribute("food",food);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "food/add";
    }

    @PutMapping("/back/food")
    public String updateFood(Food food){
        foodService.updateFood(food);
        return "redirect:/back/foods";
    }

    @DeleteMapping("/back/food/{id}")
    public String deleteFood(@PathVariable("id") Integer id){
        foodService.delFood(id);
        return "redirect:/back/foods";
    }
}
