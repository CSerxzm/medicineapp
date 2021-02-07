package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.service.PrescrService;
import com.xzm.medicineapp.service.RumorService;
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
public class RumorController {

    @Autowired
    private RumorService rumorService;
    @ResponseBody
    @RequestMapping("getrumorbyid")
    public String getRumorById(Integer id){
        Rumor rumor = rumorService.getRumorById(id);
        return JSON.toJSONString(rumor);
    }
    @ResponseBody
    @RequestMapping("/getrumors")
    public String getRumors(PageModel pageModel){
        List<Rumor> rumorList = rumorService.getRumors(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",rumorList);
        return JSON.toJSONString(map);
    }

    /*************************后台管理*************************/

    @GetMapping("/back/rumors")
    public String backRumors(ModelMap modelMap,PageModel pageModel){
        Collection<Rumor> rumors = rumorService.getRumors(pageModel);
        modelMap.addAttribute("rumors",rumors);
        modelMap.addAttribute("pagemodel",pageModel);
        return "rumor/list";
    }

    @GetMapping("/back/rumorinfo/{id}")
    public String toInfoPage(@PathVariable("id") Integer id,ModelMap modelMap){
        Rumor rumor = rumorService.getRumorById(id);
        modelMap.addAttribute("rumor",rumor);
        return "rumor/info";
    }

    @GetMapping("/back/rumor")
    public String toAddPage(){
        return "rumor/add";
    }

    @PostMapping("/back/rumor")
    public String addRumor(Rumor rumor){
        rumorService.addRumor(rumor);
        return "redirect:/back/rumors";
    }

    @GetMapping("/back/rumor/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap){
        Rumor rumor = rumorService.getRumorById(id);
        modelMap.addAttribute("rumor",rumor);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "rumor/add";
    }

    @PutMapping("/back/rumor")
    public String updateRumor(Rumor rumor){
        rumorService.updateRumor(rumor);
        return "redirect:/back/rumors";
    }

    @DeleteMapping("/back/rumor/{id}")
    public String deleteRumor(@PathVariable("id") Integer id){
        rumorService.delRumor(id);
        return "redirect:/back/rumors";
    }
}
