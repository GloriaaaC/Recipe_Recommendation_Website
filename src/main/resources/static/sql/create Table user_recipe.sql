-- mysql
drop table if exists user_recipe;

create table user_recipe (
                             `rid` Int AUTO_INCREMENT comment '菜谱id',
                             `recipe_id` Int comment '菜谱api_id',
                             `uid` Int comment '用户id',
                             `recipe_name` Varchar(120) NOT NULL comment '菜谱名字',
                             `image_url` Varchar(120) comment '图片URL',
                             `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                             `is_favorite` Int comment '是否收藏 0-未收藏 1-已收藏',

                             `created_user` Varchar(20) comment '日志-创建者',
                             `created_time` Timestamp comment '日志-创建时间',
                             `modified_user` Varchar(20) comment '日志-最后修改人',
                             `modified_time` Timestamp comment '日志-最后修改时间',

                             primary key (rid)
) CHARSET = utf8;