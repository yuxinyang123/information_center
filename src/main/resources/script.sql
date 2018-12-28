create table if not exists tbl_avg
(
  ID        bigint auto_increment
    primary key,
  SEMESTER  varchar(128) default '' not null
  comment '学期',
  CLASSNAME varchar(128)            not null
  comment '班级名称',
  FENGSHU   double(8, 2)            not null
)
  charset = utf8;

create table if not exists tbl_center
(
  CENTER_ID    bigint auto_increment
    primary key,
  USER_KEY     bigint not null
  comment '用户外键',
  WEATHER_CODE int    not null
  comment '天气api'
)
  charset = utf8;

create table if not exists tbl_center_degree
(
  DEGREE_ID               bigint auto_increment
    primary key,
  DEGREE_USERKEY          bigint default '0'        not null
  comment '外键',
  DEGREE_TERM             varchar(32) charset utf8  not null
  comment '学期',
  DEGREE_CLASSNAME        varchar(128) charset utf8 not null
  comment '课程名字',
  DEGREE_CLASSNATURE      varchar(32) charset utf8  not null
  comment '课程类型',
  DEGREE_CREDIT           double(8, 2)              not null
  comment '学分',
  DEGREE_GRADE            varchar(128)              not null
  comment '成绩',
  DEGREE_PERFORMANCEPOINT double(8, 2)              not null
  comment '绩点',
  DEGREE_TESTNATURE       varchar(255) charset utf8 not null
  comment '考试类型',
  DEGREE_STUDENTID        int                       not null
  comment '学号',
  DEGREE_STUDENTNAME      varchar(128) charset utf8 not null
  comment '学生名字'
);

create table if not exists tbl_comment
(
  COMMENT_ID          bigint auto_increment
    primary key,
  RES_KEY             bigint                not null
  comment '文章外键',
  USER_KEY            bigint                not null
  comment '用户外键',
  COMMENT_CHILD_ID    bigint default '0'    not null
  comment '子id',
  COMMENT_PARENT_ID   bigint default '0'    not null
  comment '评论父id',
  COMMENT_DATE        datetime              not null,
  COMMENT_ISANONYMITY varchar(8) default '' not null
  comment '是否匿名',
  COMMENT_CONTEXT     mediumtext            not null
)
  comment '评论表'
  charset = utf8;

create table if not exists tbl_hotspot
(
  HOTSPOT_ID     int(8) auto_increment
  comment '热点ID'
    primary key,
  HOTSPOT_TITLE  varchar(128) null
  comment '热点标题',
  HOTSPOT_HOTNUM varchar(128) null
  comment '热点数',
  HOTSPOT_HOTURL varchar(256) null
  comment 'url'
)
  comment '热点信息'
  charset = utf8;

create table if not exists tbl_premission
(
  PRMS_ID         bigint auto_increment
    primary key,
  ROLE_KEY        bigint       not null
  comment 'ROLE外键',
  PRMS_PREMISSION varchar(255) not null
  comment '权限名称'
)
  charset = utf8;

create table if not exists tbl_res_type
(
  TYPE_ID   bigint auto_increment
    primary key,
  TYPE_NAME varchar(255) not null
)
  comment '竞赛信息'
  charset = utf8;

create table if not exists tbl_resource
(
  RES_ID           bigint auto_increment
    primary key,
  TYPE_KEY         bigint                 not null,
  RES_TITLE        varchar(255)           not null,
  RES_AUTHOR       varchar(255)           not null,
  RES_SOURCE       varchar(255)           not null,
  RES_DATE         datetime               not null,
  RES_CONTEXT      longtext               not null,
  RES_COMMENTCOUNT bigint(12) default '0' null
)
  comment '资源表 所有信息'
  charset = utf8;

create table if not exists tbl_role
(
  ROLE_ID   bigint auto_increment
    primary key,
  ROLE_NAME varchar(255) not null
  comment '角色名',
  `LEFT`    bigint(255)  not null
  comment '左值',
  `RIGHT`   bigint(255)  not null
  comment '右值',
  LAYER     bigint(255)  not null
  comment '层级'
)
  comment '使用左右值建立无限层级的角色表
'
  charset = utf8;

create table if not exists tbl_syllabus
(
  SYLLABUS_ID        bigint auto_increment
    primary key,
  SYLLABUS_CLASSNAME varchar(255)              not null
  comment '课程名',
  SYLLABUS_STARTWEEK int(8) default '0'        not null
  comment '起始周',
  SYLLABUS_ENDWEEK   int(8) default '0'        not null
  comment '终止周',
  SYLLABUS_STARTPART int(8) default '0'        not null
  comment '起始节数',
  SYLLABUS_ENDPART   int(8) default '0'        not null
  comment '终止节数',
  SYLLABUS_WEEK      varchar(255) default ''   not null
  comment '星期',
  SYLLABUS_CLASSROOM varchar(255) default ''   not null
  comment '地址',
  SYLLABUS_TEACHER   varchar(255) default '佚名' not null
  comment '教师',
  USERKEY            bigint                    not null
  comment '用户外键'
)
  charset = utf8;

create table if not exists tbl_user
(
  USER_ID    bigint auto_increment
    primary key,
  USER_NAME  varchar(255) not null
  comment '昵称',
  USER_EMAIL varchar(255) not null
  comment '登录邮箱',
  USER_PHONE varchar(255) not null
  comment '手机（可用于注册',
  USER_PASS  varchar(255) not null
  comment '密码',
  USER_ISBAN varchar(255) not null
)
  charset = utf8;

create table if not exists tbl_user_information
(
  INF_ID        bigint auto_increment
    primary key,
  USER_KEY      bigint       not null
  comment '用户外键',
  INF_NUM       int          null
  comment '教务学号',
  INF_PASS      varchar(255) null
  comment '教务密码',
  INF_SIGNATURE varchar(255) null
  comment '个人签名',
  INF_ACADEMY   varchar(255) null
  comment '学院',
  INF_MAJOR     varchar(255) null
  comment '专业',
  INF_CLASS     varchar(255) null
  comment '班级',
  INF_SEX       varchar(255) null,
  INF_LOCALTION varchar(255) null
  comment '地理位置',
  INF_AGE       varchar(255) null
)
  charset = utf8;

create table if not exists tbl_user_role
(
  UR_ID    bigint auto_increment
    primary key,
  USER_KEY bigint not null,
  ROLE_KEY bigint not null
)
  charset = utf8;

create table if not exists tbl_weather
(
  WEATHER_CODE        int default '0' not null
  comment 'API中的code'
    primary key,
  WEATHER_CITY_NAME   varchar(255)    null
  comment '城市名称',
  WEATHER_DATE        varchar(255)    null
  comment '时间',
  WEATHER_SUNRISE     varchar(255)    null
  comment '日出时间',
  WEATHER_HIGH        varchar(255)    null
  comment '最高气温',
  WEATHER_LOW         varchar(255)    null
  comment '最低气温',
  WEATHER_SUNSET      varchar(255)    null
  comment '日落时间',
  WEATHER_TEMPERATURE varchar(255)    null
  comment '温度',
  WEATHER_AQI         float           null,
  WEATHER_NOTICE      varchar(255)    null
  comment '小提示',
  WEATHER_TYPE        varchar(255)    null
  comment '天气类型',
  WEATHER_FL          varchar(255)    null
  comment '风力',
  WEATHER_FX          varchar(255)    null
  comment '风向'
)
  comment 'api对应的天气表'
  charset = utf8;


