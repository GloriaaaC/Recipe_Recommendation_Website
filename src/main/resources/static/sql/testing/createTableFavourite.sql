drop table if exists t_favourite;

CREATE TABLE `t_favourite` (
                             `id` int auto_increment NOT NULL comment '收藏夹id',
                             `user_id` int NOT NULL comment '用户id',
                             `title` varchar(20) NOT NULL comment '收藏夹标题',
                             `create_time` TIMESTAMP default CURRENT_TIMESTAMP comment '建造时间',

                             `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                             `created_user` Varchar(20) comment '日志-创建者',
                             `created_time` Timestamp comment '日志-创建时间',
                             `modified_user` Varchar(20) comment '日志-最后修改人',
                             `modified_time` Timestamp comment '日志-最后修改时间',
                             PRIMARY KEY (`id`)
) CHARSET = utf8;