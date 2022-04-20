-- mysql

drop table if exists folder_recipe;

create table folder_recipe (
                               `id` Int AUTO_INCREMENT comment 'id',
                               `folder_id` INT NOT NULL comment '文件夹id',
                               `recipe_id` Int NOT NULL comment '菜谱id',
                               `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                               `created_user` Varchar(20) comment '日志-创建者',
                               `created_time` Timestamp comment '日志-创建时间',
                               `modified_user` Varchar(20) comment '日志-最后修改人',
                               `modified_time` Timestamp comment '日志-最后修改时间',

                               primary key (id)
) CHARSET = utf8;