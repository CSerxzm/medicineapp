/*中医善养APP数据库设计*/
drop database if exists medicineapp;
create database medicineapp default character set utf8 collate utf8_general_ci;
use  medicineapp;

/*养生知识表（health_tb）*/
create table health_tb(
	id int(11) primary key auto_increment,
	title varchar(18) comment '文章标题',
	author varchar(18) comment '作者,出处',
	edit_time datetime comment '发布时间',
	content text comment '内容',
	main_type varchar(18) comment '主类别，节气，四季，人群',
	sub_type varchar(18) comment '子类别，气节则为二十四节气，四季则是春夏秋冬，人群则为中老幼',
	views int(11) default 0 comment '浏览量'
);
/*中医药科普表（medicine-tb）*/
create table medicine_tb(
	id int(11) primary key auto_increment,
	name varchar(18) comment '名字',
	nickname varchar(18) comment '别名',
	image varchar(30) comment '图片',
	funs varchar(30) comment '作用',
	taboos varchar(30) comment '禁忌'
);
/*中药方表(prescr_tb)*/
create table prescr_tb(
	id int(11) primary key auto_increment,
	name varchar(18) comment '方名',
	compose varchar(30) comment '组成',
	funs varchar(30) comment '作用',
	source varchar(30) comment '出处'
);
/*中医药辟谣表(rumor_tb)*/
create table rumor_tb(
	id int(11) primary key auto_increment,
	title varchar(18) comment '标题',
	content text comment '内容',
	source varchar(30) comment '出处',
	reality varchar(30) comment '真实否'
);
/*食疗表(food_tb)*/
create table food_tb(
	id int(11) primary key auto_increment,
	name varchar(18) comment '食谱名',
	compose varchar(18) comment '用料',
	method text comment '做法',
	funs varchar(30) comment '功效'
);

/*用户表(user_tb)*/
create table user_tb(
	name varchar(18) primary key comment '用户名,主键',
	password varchar(18) comment '密码',
	image varchar(30) comment '头像',
	authority varchar(18) comment '权限'
);

/*养生论坛表(forum_tb)*/
create table forum_tb(
	id int(11) primary key auto_increment,
	name varchar(18) default null comment '作者,外键',
	edit_time datetime comment '时间',
	content text comment '内容',
	keyword varchar(18) comment '关键字',
	views int(11) default 0 comment '浏览量',
	comments int(11) default 0 comment '评论数',
	foreign key(name) references user_tb(name) on delete cascade on update cascade
);

/*论坛评论表(comments_tb)*/
create table comment_tb(
	id int(11) primary key auto_increment,
	forum_id int(11) default null comment '养生论坛id,外键',
	name varchar(18) default null comment '评论者,外键',
	edit_time datetime comment '评论时间',
	content text comment '内容',
	foreign key(name) references user_tb(name) on delete cascade on update cascade,
	foreign key(forum_id) references forum_tb(id) on delete cascade on update cascade
);


/*适当的插入数据*/

insert into health_tb(title,author,edit_time,content,main_type,sub_type,views) values
('冬季吃羊肉的五大禁忌','51健康助手','2017-09-18 08:00:00','1.忌冷；2.极寒','四季','冬季',100),
('夏季吃羊肉的五大禁忌','51健康助手','2017-09-18 08:00:00','1.忌冷；2.极寒','四季','夏季',100),
('春季吃羊肉的五大禁忌','51健康助手','2017-09-18 08:00:00','1.忌冷；2.极寒','四季','春季',100),
('冬至吃羊肉的五大禁忌','51健康助手','2017-09-18 08:00:00','1.忌冷；2.极寒','气节','冬至',100),
('老年人吃羊肉的五大禁忌','51健康助手','2017-09-18 08:00:00','1.忌冷；2.极寒','人群','老年',100);
insert into medicine_tb(name,nickname,image,funs,taboos) values
('八月瓜','木瓜',null,'用法：煎汤，3-10g；或入丸，散。外用，煎水洗；或研磨调涂','祛风散热，除湿止痛'),
('艾草','艾蒿',null,'用法：煎汤，3-10g；或入丸，散。外用，煎水洗；或研磨调涂','祛风散热，除湿止痛');
insert into prescr_tb(name,compose,funs,source) values
('千金散','当归，大枣，芍药','治风湿，提气血','本草纲目'),
('千金散','当归，大枣，芍药','治风湿，提气血','本草纲目'),
('千金散','当归，大枣，芍药','治风湿，提气血','本草纲目'),
('千金散','当归，大枣，芍药','治风湿，提气血','本草纲目');
insert into rumor_tb(title,content,source,reality) values
('三金双黄连口服液可以治疗肺炎','三金双黄连口服液可以治疗肺炎','百度辟谣','true'),
('抽烟可以治疗肺炎','抽烟可以治疗肺炎','阿里辟谣','false');
insert into food_tb(name,compose,method,funs) values
('枸杞银耳汤','枸杞，银耳，水','枸杞加上银耳，煮10小时即可','强身健体'),
('枸杞银耳汤','枸杞，银耳，水','枸杞加上银耳，煮10小时即可','强身健体'),
('枸杞银耳汤','枸杞，银耳，水','枸杞加上银耳，煮10小时即可','强身健体');
insert into user_tb(name,password,image,authority) values
('root','password',null,'root'),
('user1','password',null,'user'),
('user2','password',null,'user');
insert into forum_tb(name,edit_time,content,keyword,views,comments) values
('user1','2017-09-18 08:00:00','老风湿30年，一直被折磨，有没有一起治疗的','风湿病',100,0),
('user1','2017-09-18 08:00:00','糖尿病3年，一直被折磨，有没有一起治疗的','糖尿病',100,0),
('user2','2017-09-18 08:00:00','高血压20年，一直被折磨，有没有一起治疗的','高血压',100,0);

insert into comment_tb(forum_id,name,edit_time,content) values
(1,'user2','2017-09-18 08:00:00','我也是，一起吧？'),
(1,'user2','2017-09-18 08:00:00','三十年你怎么过来的'),
(2,'user2','2017-09-18 08:00:00','糖尿病，你目前多少岁');



