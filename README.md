# medicineapp
##### 数据表的设计见 sql/mysql.sql
##### 该项目为app提供接口，并且提供管理员界面，但没有分页处理、登录权限处理，后续添加
##### 项目涉及的技术springboot+mybatis，开发工具使用idea以及maven
##### 对于数据的返回，采用json返回，降低传输量
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
     public String getUsers(){
         List<User> users = userService.getUsers();
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
    public String getHealthsByType(@Param("main_type") String main_type, @Param("sub_type") String sub_type){
        List<Health> healthList = healthService.getHealthsByType(main_type,sub_type);
        return JSON.toJSONString(healthList);
    }
    @ResponseBody
    @RequestMapping("/gethealths")
    public String getHealths(){
        List<Health> healthList = healthService.getHealths();
        return JSON.toJSONString(healthList);
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
    public String getMedicines(){
        List<Medicine> medicineList = medicineService.getMedicines();
        return JSON.toJSONString(medicineList);
    }
```
* 中医药方请求
```
    @ResponseBody
    @RequestMapping("/getprescrbyid")
    public String getOneById(Integer id){
        Prescr prescr = prescrService.getPrescrById(id);
        return JSON.toJSONString(prescr);
    }
    @ResponseBody
    @RequestMapping("/getprescrs")
    public String getPrescrs(){
        List<Prescr> prescrList = prescrService.getPrescrs();
        return JSON.toJSONString(prescrList);
    }
```
* 辟谣模块请求
```
    @ResponseBody
    @RequestMapping("getrumorbyid")
    public String getRumorById(Integer id){
        Rumor rumor = rumorService.getRumorById(id);
        return JSON.toJSONString(rumor);
    }
    @ResponseBody
    @RequestMapping("/getrumors")
    public String getRumors(){
        List<Rumor> rumorList = rumorService.getRumors();
        return JSON.toJSONString(rumorList);
    }
```
* 食疗养生请求
```
    @ResponseBody
    @RequestMapping("getrumorbyid")
    public String getRumorById(Integer id){
        Rumor rumor = rumorService.getRumorById(id);
        return JSON.toJSONString(rumor);
    }
    @ResponseBody
    @RequestMapping("/getrumors")
    public String getRumors(){
        List<Rumor> rumorList = rumorService.getRumors();
        return JSON.toJSONString(rumorList);
    }
```
* 养生论坛请求
```    
@ResponseBody
       @RequestMapping("/getforums")
       public String getForums(){
           List<Forum> forumList = forumService.getForums();
           return JSON.toJSONString(forumList);
       }
       @ResponseBody
       @RequestMapping("/getforumbyid")
       public String getForumById(Integer id){
           Forum forum = forumService.getForumById(id);
           return JSON.toJSONString(forum);
       }
       @ResponseBody
       @RequestMapping("/addforum")
       public String addForum(Forum forum){
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
    public String addComment(Comment comment){
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
    * 接口访问网址示例 `http://47.102.155.48:8080/medicineapp/gethealths`  
    返回示例：
```$xslt
[
    {
        "author":"51健康助手",
        "content":"1.忌冷；2.极寒",
        "editTime":"2017-09-18 08:00:00.0",
        "id":1,
        "mainType":"四季",
        "subType":"冬季","
        title":"冬季吃羊肉的五大禁忌",
        "views":100
    },
    
    {
        "author":"51健康助手",
        "content":"1.忌冷；2.极寒",
        "editTime":"2017-09-18 08:00:00.0",
        "id":2,
        "mainType":"四季",
        "subType":"夏季",
        "title":"夏季吃羊肉的五大禁忌",
        "views":100
    }
]
```

