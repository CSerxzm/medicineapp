package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.bean.User;
import com.xzm.medicineapp.service.PrescrService;
import com.xzm.medicineapp.service.UserService;
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
public class PrescrController {

    @Autowired
    private PrescrService prescrService;
    @ResponseBody
    @RequestMapping("/getprescrbyid")
    public String getOneById(Integer id){
        Prescr prescr = prescrService.getPrescrById(id);
        return JSON.toJSONString(prescr);
    }
    @ResponseBody
    @RequestMapping("/getprescrs")
    public String getPrescrs(PageModel pageModel){
        List<Prescr> prescrList = prescrService.getPrescrs(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",prescrList);
        return JSON.toJSONString(map);
    }
    /*************************后台管理*************************/

    @GetMapping("/back/prescrs")
    public String backPrescrs(ModelMap modelMap,PageModel pageModel){
        Collection<Prescr> prescrs = prescrService.getPrescrs(pageModel);
        modelMap.addAttribute("prescrs",prescrs);
        modelMap.addAttribute("pagemodel",pageModel);
        return "prescr/list";
    }

    @GetMapping("/back/prescrinfo/{id}")
    public String toInfoPage(@PathVariable("id") Integer id,ModelMap modelMap){
        Prescr prescr = prescrService.getPrescrById(id);
        modelMap.addAttribute("prescr",prescr);
        return "prescr/info";
    }

    @GetMapping("/back/prescr")
    public String toAddPage(){
        return "prescr/add";
    }

    @PostMapping("/back/prescr")
    public String addPrescr(Prescr prescr){
        prescrService.addPrescr(prescr);
        return "redirect:/back/prescrs";
    }

    @GetMapping("/back/prescr/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap){
        Prescr prescr = prescrService.getPrescrById(id);
        modelMap.addAttribute("prescr",prescr);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "prescr/add";
    }

    @PutMapping("/back/prescr")
    public String updatePrescr(Prescr prescr){
        prescrService.updatePrescr(prescr);
        return "redirect:/back/prescrs";
    }

    @DeleteMapping("/back/prescr/{id}")
    public String deletePrescr(@PathVariable("id") Integer id){
        prescrService.delPrescr(id);
        return "redirect:/back/prescrs";
    }
}
