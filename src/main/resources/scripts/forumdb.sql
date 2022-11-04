DROP DATABASE IF EXISTS forumdb;
DROP USER IF EXISTS `forum-admin`@`%`;
DROP USER IF EXISTS `forum-user`@`%`;


CREATE DATABASE IF NOT EXISTS forumdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `forum-admin`@`%` IDENTIFIED WITH mysql_native_password BY 'adminpassword';
GRANT * ON `forumdb`.* TO `forum-admin`@`%`;