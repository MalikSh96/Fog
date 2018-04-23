DROP DATABASE IF EXISTS `FogUsers`;

CREATE DATABASE `FogUsers`;

USE `FogUsers`;

DROP TABLE IF EXISTS `users`;


create table `users` (
`email` varchar(45),
`user_id` int auto_increment primary key,
`password` varchar(45),
`isAdmin` boolean
);