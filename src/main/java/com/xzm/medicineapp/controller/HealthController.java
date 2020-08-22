package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.service.HealthService;
import org.apache.ibatis.annotations.Param;
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
public class HealthController {

    @Autowired
    private HealthService healthService;
    @ResponseBody
    @RequestMapping("/getHealthById")
    public String getHealthById(Integer id){
        Health health = healthService.getHealthById(id);
        return JSON.toJSONString(health);
    }
    @ResponseBody
    @RequestMapping("/getHeathByType")
    public String getHealthsByType(@Param("main_type") String main_type, @Param("sub_type") String sub_type){
        List<Health> healthList = healthService.getHealthsByType(main_type,sub_type);
        return JSON.toJSONString(healthList);
    }
    @ResponseBody
    @RequestMapping("/getHealths")
    public String getHealths(){
        List<Health> healthList = healthService.getHealths();
        return JSON.toJSONString(healthList);
    }
}
