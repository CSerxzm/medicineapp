package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import org.codehaus.groovy.transform.sc.transformers.ListExpressionTransformer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 3052
 * @create 2020-08-24 13:53
 */
@RestController
public class AppController {
    @RequestMapping("/getimages")
    public String getGoods(){
        List<Map> mapList = new ArrayList();
        Map map1 = new HashMap();
        map1.put("image_src","http://47.102.155.48:8080/pic_medicineapp/2.png");
        map1.put("open_type","navigate");
        map1.put("goods_id",129);
        map1.put("navigator_url","navigate");
        mapList.add(map1);
        Map map2 = new HashMap();
        map2.put("image_src","http://47.102.155.48:8080/pic_medicineapp/1.png");
        map2.put("open_type","navigate");
        map2.put("goods_id",300);
        map2.put("navigator_url","navigate");
        mapList.add(map2);
        Map map = new HashMap();
        map.put("message",mapList);
        Map map_temp = new HashMap();
        map_temp.put("msg","获取成功");
        map_temp.put("status",200);
        map.put("meta",map_temp);
        return JSON.toJSONString(map);

    }
}
