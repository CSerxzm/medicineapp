package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.service.PrescrService;
import com.xzm.medicineapp.service.UserService;
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
public class PrescrController {

    @Autowired
    private PrescrService prescrService;
    @ResponseBody
    @RequestMapping("/getPrescrById")
    public String getOneById(Integer id){
        Prescr prescr = prescrService.getPrescrById(id);
        return JSON.toJSONString(prescr);
    }
    @ResponseBody
    @RequestMapping("/getPrescrs")
    public String getPrescrs(){
        List<Prescr> prescrList = prescrService.getPrescrs();
        return JSON.toJSONString(prescrList);
    }
}
