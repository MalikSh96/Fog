DROP DATABASE IF EXISTS `FogUsers`;

CREATE DATABASE `FogUsers`;

USE `FogUsers`;

DROP TABLE IF EXISTS `users`;


create table `users` (
`email` varchar(90),
`id` int auto_increment primary key,
`password` varchar(45),
`role` varchar(20) NOT NULL DEFAULT 'customer',
UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

