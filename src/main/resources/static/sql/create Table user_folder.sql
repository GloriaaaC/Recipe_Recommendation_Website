-- mysql

drop table if exists user_folder;

create table user_folder (
                             `id` Int AUTO_INCREMENT comment '文件夹id',
                             `folder_name` Varchar(20) NOT NULL comment '文件夹名字',
                             `user_id` Int NOT NULL comment '用户id',
                             `is_delete` Int comment '是否删除 0-未删除 1-已删除',
                             `created_user` Varchar(20) comment '日志-创建者',
                             `created_time` Timestamp comment '日志-创建时间',
                             `modified_user` Varchar(20) comment '日志-最后修改人',
                             `modified_time` Timestamp comment '日志-最后修改时间',

                             primary key (id)
) CHARSET = utf8;