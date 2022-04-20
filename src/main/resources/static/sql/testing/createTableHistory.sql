drop table if exists t_history;

CREATE TABLE `t_history` (
                             `id` int auto_increment NOT NULL comment '历史id',
                             `user_id` int NOT NULL comment '用户id',
                             `recipe_id` int NOT NULL comment '食谱id',
                             `browse_time` TIMESTAMP default CURRENT_TIMESTAMP comment '浏览时间',

                             `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                             `created_user` Varchar(20) comment '日志-创建者',
                             `created_time` Timestamp comment '日志-创建时间',
                             `modified_user` Varchar(20) comment '日志-最后修改人',
                             `modified_time` Timestamp comment '日志-最后修改时间',
                             PRIMARY KEY (`id`)
) CHARSET = utf8;