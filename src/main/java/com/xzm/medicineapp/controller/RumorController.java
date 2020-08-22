package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.service.PrescrService;
import com.xzm.medicineapp.service.RumorService;
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
public class RumorController {

    @Autowired
    private RumorService rumorService;
    @ResponseBody
    @RequestMapping("getRumorById")
    public String getRumorById(Integer id){
        Rumor rumor = rumorService.getRumorById(id);
        return JSON.toJSONString(rumor);
    }
    @ResponseBody
    @RequestMapping("/getRumors")
    public String getRumors(){
        List<Rumor> rumorList = rumorService.getRumors();
        return JSON.toJSONString(rumorList);
    }
}
