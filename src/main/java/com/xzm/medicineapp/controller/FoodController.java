package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Food;
import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.service.FoodService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String getFoods(PageModel pageModel){
        List<Food> foodList=foodService.getFoods(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",foodList);
        return JSON.toJSONString(map);
    }
    /*************************后台管理*************************/

    @GetMapping("/back/foods")
    public String backFoods(ModelMap modelMap,PageModel pageModel){
        Collection<Food> foods = foodService.getFoods(pageModel);
        modelMap.addAttribute("foods",foods);
        modelMap.addAttribute("pagemodel",pageModel);
        return "food/list";
    }

    @GetMapping("/back/foodinfo/{id}")
    public String toInfoPage(@PathVariable("id") Integer id,ModelMap modelMap){
        Food food = foodService.getFoodById(id);
        modelMap.addAttribute("food",food);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "food/info";
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
