# medicineapp
##### 数据表的设计见 sql/mysql.sql。
##### 该项目为小程序提供接口，并且提供管理员界面，但没有管理端没有分页处理，后续添加。
##### 项目涉及的技术springboot+mybatis，开发工具使用idea以及maven
##### 对于数据的返回，采用json返回，降低传输量。
## 接口详细设计
* 用户请求
 ```
    @ResponseBody
    @RequestMapping("/login")
    public String login(User user){
        boolean flag = userService.login(user);
        return JSON.toJSONString(flag);
    }
    @ResponseBody
    @RequestMapping("/getusers")
    public String getUsers(PageModel pageModel){
        List<User> users = userService.getUsers(pageModel);
        return JSON.toJSONString(users);
    }
 ```
 * 养生知识请求
```
    @ResponseBody
    @RequestMapping("/gethealthbyid")
    public String getHealthById(Integer id){
        Health health = healthService.getHealthById(id);
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
```
 * 医药科普请求
```
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
```
* 中医药方请求
```
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
```
* 辟谣模块请求
```
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
```
* 食疗养生请求
```
    @ResponseBody
    @RequestMapping("/getfoodbyid")
    public String getFoodById(Integer id){
        Food food = foodService.getFoodById(id);
        return JSON.toJSONString(food);
    }
    @ResponseBody
    @RequestMapping("/getfoods")
    public String getFoods(PageModel pageModel){
        List<Food> foodList=foodService.getFoods(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",foodList);
        return JSON.toJSONString(map);
    }
```
* 养生论坛请求
```    
    @ResponseBody
    @RequestMapping("/getforums")
    public String getForums(PageModel pageModel){
        List<Forum> forumList = forumService.getForums(pageModel);
        Map<String,Object> map = new HashMap();
        map.put("page",pageModel);
        map.put("data",forumList);
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @RequestMapping("/getforumbyid")
    public String getForumById(Integer id){
        Forum forum = forumService.getForumById(id);
        return JSON.toJSONString(forum);
    }
    @ResponseBody
    @RequestMapping("/addforum")
    public String addForum(Forum forum,String name){
        User user = new User();
        user.setName(name);
        forum.setUser(user);
        Integer result = forumService.addForum(forum);
        return  JSON.toJSONString(forum);
    }
    @ResponseBody
    @RequestMapping("delforumbyid")
    public String delForumById(Integer id){
        Integer result = forumService.delForumById(id);
        return  JSON.toJSONString(result);
    }
```
* 论坛评论请求
```
    @ResponseBody
    @RequestMapping("/getcommentsbyforumid")
    public String getCommentsByForumId(Integer forum_id){
        List<Comment> commentList = commentService.getCommentsByForumId(forum_id);
        return JSON.toJSONString(commentList);
    }
    @ResponseBody
    @RequestMapping("/addcomment")
    public String addComment(Comment comment,String name){
        User user = new User();
        user.setName(name);
        comment.setUser(user);
        Integer result = commentService.addComment(comment);
        return JSON.toJSONString(comment);
    }
    @ResponseBody
    @RequestMapping("/delcommentbyid")
    public String delCommentById(Integer id){
        Integer result = commentService.delCommentById(id);
        return JSON.toJSONString(result);
    }
```
* 测试地址:  
    * 后台网址[http://47.102.155.48:8080/medicineapp/](http://47.102.155.48:8080/medicineapp/)  
    * 接口访问网址示例 `http://47.102.155.48:8080/medicineapp/gethealths?pageIndex=4`  
    返回示例：
```$xslt
{
	"data": [{
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 31,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌4",
		"views": 100
	}, {
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 32,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌5",
		"views": 100
	}, {
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 33,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌6",
		"views": 100
	}, {
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 34,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌7",
		"views": 100
	}, {
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 35,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌8",
		"views": 100
	}, {
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 36,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌9",
		"views": 100
	}, {
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 37,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌10",
		"views": 100
	}, {
		"author": "51健康助手",
		"content": "1.忌冷；2.极寒",
		"editTime": "2017-09-18 08:00:00.0",
		"id": 38,
		"image": "http://47.102.155.48:8080/pic_medicineapp/yu.png",
		"mainType": 2,
		"subType": 2,
		"title": "老年人吃羊肉的五大禁忌11",
		"views": 100
	}],
	"page": {
		"firstLimitParam": 30,
		"pageIndex": 4,
		"pageSize": 10,
		"recordCount": 38,
		"totalSize": 4
	}
}
```