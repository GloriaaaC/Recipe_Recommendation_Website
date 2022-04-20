DROP TABLE IF EXISTS folder_recipe;

CREATE TABLE folder_recipe (
    `id` INT AUTO_INCREMENT,
    `folder_id` INT NOT NULL,
    `recipe_id` INT NOT NULL,
    `is_delete` INT,
    `created_user` VARCHAR(20),
    `created_time` TIMESTAMP,
    `modified_user` VARCHAR(20),
    `modified_time` TIMESTAMP,
    PRIMARY KEY (id)
) CHARSET = UTF8;

DROP TABLE IF EXISTS recipe_review;

CREATE TABLE `recipe_review` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `recipe_id` INT NOT NULL,
    `rating` INT,
    `review` VARCHAR(1000),
    `user_id` INT,
    `is_delete` INT,
    `created_user` VARCHAR(20),
    `created_time` TIMESTAMP,
    `modified_user` VARCHAR(20),
    `modified_time` TIMESTAMP,
    PRIMARY KEY (`id`)
) CHARSET = UTF8;

DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user (
    `uid` INT AUTO_INCREMENT,
    `username` VARCHAR(20) NOT NULL UNIQUE,
    `password` CHAR(32) NOT NULL,
    `salt` CHAR(36),
    `phone` VARCHAR(20),
    `gender` INT,
    `email` VARCHAR(100),
    `avatar` VARCHAR(50),
    `is_delete` INT,
    `created_user` VARCHAR(20),
    `created_time` TIMESTAMP,
    `modified_user` VARCHAR(20),
    `modified_time` TIMESTAMP,
    PRIMARY KEY (uid)
) CHARSET = UTF8;

DROP TABLE IF EXISTS user_folder;

CREATE TABLE user_folder (
    `id` INT AUTO_INCREMENT,
    `folder_name` VARCHAR(20) NOT NULL,
    `user_id` INT NOT NULL,
    `is_delete` INT,
    `created_user` VARCHAR(20),
    `created_time` TIMESTAMP,
    `modified_user` VARCHAR(20),
    `modified_time` TIMESTAMP,
    PRIMARY KEY (id)
) CHARSET = UTF8;

DROP TABLE IF EXISTS user_recipe;

CREATE TABLE user_recipe (
    `rid` INT AUTO_INCREMENT,
    `recipe_id` INT,
    `uid` INT,
    `recipe_name` VARCHAR(120) NOT NULL,
    `image_url` VARCHAR(120),
    `is_delete` INT,
    `is_favorite` INT,
    `created_user` VARCHAR(20),
    `created_time` TIMESTAMP,
    `modified_user` VARCHAR(20),
    `modified_time` TIMESTAMP,
    PRIMARY KEY (rid)
) CHARSET = UTF8;