package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.service.HealthService;
import com.xzm.medicineapp.service.MedicineService;
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
public class MedicineController {

    @Autowired
    private MedicineService medicineService;
    @ResponseBody
    @RequestMapping("/getmedicinebyid")
    public String getMedicineById(Integer id){
        Medicine medicine = medicineService.getMedicineById(id);
        return JSON.toJSONString(medicine);
    }

    @ResponseBody
    @RequestMapping("/getmedicines")
    public String getMedicines(PageModel pageModel){
        List<Medicine> medicineList = medicineService.getMedicines(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",medicineList);
        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping("/searchmedicines")
    public String searchMedicines(PageModel pageModel,String name){
        List<Medicine> medicineList = medicineService.searchMedicines(pageModel,name);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",medicineList);
        return JSON.toJSONString(map);
    }


    /*************************后台管理*************************/

    @GetMapping("/back/medicines")
    public String backMedicines(ModelMap modelMap,PageModel pageModel){
        Collection<Medicine> medicines = medicineService.getMedicines(pageModel);
        modelMap.addAttribute("medicines",medicines);
        modelMap.addAttribute("pagemodel",pageModel);
        return "medicine/list";
    }

    @GetMapping("/back/medicine")
    public String toAddPage(){
        return "medicine/add";
    }

    @PostMapping("/back/medicine")
    public String addMedicine(Medicine medicine){
        medicineService.addMedicine(medicine);
        return "redirect:/back/medicines";
    }

    @GetMapping("/back/medicineinfo/{id}")
    public String toInfoPage(@PathVariable("id") Integer id,ModelMap modelMap){
        Medicine medicine = medicineService.getMedicineById(id);
        modelMap.addAttribute("medicine",medicine);
        return "medicine/info";
    }

    @GetMapping("/back/medicine/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap){
        Medicine medicine = medicineService.getMedicineById(id);
        modelMap.addAttribute("medicine",medicine);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "medicine/add";
    }

    @PutMapping("/back/medicine")
    public String updateMedicine(Medicine medicine){
        medicineService.updateMedicine(medicine);
        return "redirect:/back/medicines";
    }

    @DeleteMapping("/back/medicine/{id}")
    public String deleteMedicine(@PathVariable("id") Integer id){
        medicineService.delMedicine(id);
        return "redirect:/back/medicines";
    }
}
