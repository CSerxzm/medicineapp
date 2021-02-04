package com.xzm.medicineapp.controller;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.util.HttpClientUtil;
import org.codehaus.groovy.transform.sc.transformers.ListExpressionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author xiangzhimin
 * @Description 通用接口类
 * @create 2021-01-19 19:55
 */

@RestController
public class AppController {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 上传头像的接口
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            return "http://47.102.155.48:8080/pic_medicineapp/head1.png";
        }
        String serverPath = request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort() + request.getContextPath() + "/file/";
        String path = request.getServletContext().getRealPath("/file/");
        String picNameCode = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        String picName = file.getOriginalFilename();
        String [] videos = picName.split("\\.");
        picNameCode=picNameCode+".jpg";
        File filePath = new File(path, picNameCode);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        file.transferTo(filePath);
        System.out.println(serverPath+picNameCode);
        return serverPath+picNameCode;
    }

    /**
     * 首页的两张图片
     * @return
     */
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

    /**
     * 获得星座的相关消息，免得重复请求
     * @param constellation
     */
    @RequestMapping("/getconstellation")
    public String getConstellation(String constellation) throws UnsupportedEncodingException {
        String desc = (String) redisTemplate.opsForValue().get(constellation);
        String url="http://web.juhe.cn:8080/constellation/getAll";
        Map<String, String> params = new HashMap<>();
        if(desc==null){
            params.put("consName",constellation);
            params.put("type","today");
            params.put("key","6f99d04702c95adfc2c354dfede407b0");
            desc = HttpClientUtil.doGet(url, params);
            redisTemplate.opsForValue().set(constellation, desc,10, TimeUnit.HOURS);
        }
        return desc;
    }

}
