-- mysql

drop table if exists t_user;

create table t_user (
                        `uid` Int AUTO_INCREMENT comment '用户id',
                        `username` Varchar(20) NOT NULL UNIQUE comment '用户名',
                        `password` Char(32) NOT NULL comment '密码',
                        `salt` Char(36) comment '盐值',
                        `phone` Varchar(20) comment '电话号码',
                        `gender` Int comment '性别 女:0 男:1',
                        `avatar` Varchar(50) comment '头像',
                        `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                        `created_user` Varchar(20) comment '日志-创建者',
                        `created_time` Timestamp comment '日志-创建时间',
                        `modified_user` Varchar(20) comment '日志-最后修改人',
                        `modified_time` Timestamp comment '日志-最后修改时间',

                        primary key (uid)
) CHARSET = utf8;