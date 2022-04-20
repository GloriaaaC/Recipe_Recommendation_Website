drop table if exists t_favouriteItem;

CREATE TABLE `t_favouriteItem` (
                               `id` int auto_increment NOT NULL comment 'id',
                               `favourite_id` int NOT NULL comment '收藏夹id',
                               `recipe_id` int NOT NULL comment '食谱id',
                               `create_time` TIMESTAMP default CURRENT_TIMESTAMP comment '添加收藏夹时间',

                               `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                               `created_user` Varchar(20) comment '日志-创建者',
                               `created_time` Timestamp comment '日志-创建时间',
                               `modified_user` Varchar(20) comment '日志-最后修改人',
                               `modified_time` Timestamp comment '日志-最后修改时间',
                               PRIMARY KEY (`id`)
) CHARSET = utf8;