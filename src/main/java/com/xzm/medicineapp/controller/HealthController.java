package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.service.HealthService;
import com.xzm.medicineapp.util.PageModel;
import org.apache.ibatis.annotations.Param;
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
public class HealthController {

    @Autowired
    private HealthService healthService;
    @ResponseBody
    @RequestMapping("/gethealthbyid")
    public String getHealthById(Integer id){
        Health health = healthService.getHealthById(id);
        health.setViews(health.getViews()+1);
        healthService.updateHealth(health);
        return JSON.toJSONString(health);
    }
    @ResponseBody
    @RequestMapping("/getheathbytype")
    public String getHealthsByType(@RequestParam("main_type") Integer mainType,
                                   @RequestParam("sub_type") Integer subType,
                                   PageModel pageModel){
        List<Health> healthList = healthService.getHealthsByType(mainType,subType);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",healthList);
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @RequestMapping("/gethealths")
    public String getHealths(PageModel pageModel){
        List<Health> healthList = healthService.getHealths(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",healthList);
        return JSON.toJSONString(map);
    }

    /*************************后台管理*************************/

    @GetMapping("/back/healths")
    public String backHealths(ModelMap modelMap,PageModel pageModel){
        Collection<Health> healths = healthService.getHealths(pageModel);
        modelMap.addAttribute("healths",healths);
        modelMap.addAttribute("pagemodel",pageModel);
        return "health/list";
    }

    @GetMapping("/back/health")
    public String toAddPage(){
        return "health/add";
    }

    @PostMapping("/back/health")
    public String addHealth(Health health){
        healthService.addHealth(health);
        return "redirect:/back/healths";
    }

    @GetMapping("/back/healthinfo/{id}")
    public String toInfoPage(@PathVariable("id") Integer id,ModelMap modelMap){
        Health health = healthService.getHealthById(id);
        modelMap.addAttribute("health",health);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "health/info";
    }

    @GetMapping("/back/health/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap){
        Health health = healthService.getHealthById(id);
        modelMap.addAttribute("health",health);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "health/add";
    }

    @PutMapping("/back/health")
    public String updateHealth(Health health){
        healthService.updateHealth(health);
        return "redirect:/back/healths";
    }

    @DeleteMapping("/back/health/{id}")
    public String deleteHealth(@PathVariable("id") Integer id){
        healthService.delHealth(id);
        return "redirect:/back/healths";
    }
}
