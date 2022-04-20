-- mysql
drop table if exists recipe_review;

CREATE TABLE `recipe_review` (
                                 `id` int auto_increment NOT NULL comment '评论id',
                                 `recipe_id` int NOT NULL comment '食谱id',
                                 `rating` int comment '评分1-10',
                                 `review` varchar(1000) comment '评论内容',
                                 `user_id` int comment '用户id',

                                 `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                                 `created_user` Varchar(20) comment '日志-创建者',
                                 `created_time` Timestamp comment '日志-创建时间',
                                 `modified_user` Varchar(20) comment '日志-最后修改人',
                                 `modified_time` Timestamp comment '日志-最后修改时间',
                                 PRIMARY KEY (`id`)
) CHARSET = utf8;