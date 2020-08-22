package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.service.HealthService;
import com.xzm.medicineapp.service.MedicineService;
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
public class MedicineController {

    @Autowired
    private MedicineService medicineService;
    @ResponseBody
    @RequestMapping("/getMedicineById")
    public String getMedicineById(Integer id){
        Medicine medicine = medicineService.getMedicineById(id);
        return JSON.toJSONString(medicine);
    }

    @ResponseBody
    @RequestMapping("/getMedicines")
    public String getMedicines(){
        List<Medicine> medicineList = medicineService.getMedicines();
        return JSON.toJSONString(medicineList);
    }
}
