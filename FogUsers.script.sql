DROP DATABASE IF EXISTS `FogUsers`;

CREATE DATABASE `FogUsers`;

USE `FogUsers`;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `carports`;

create table `users` (
`name` varchar(90),
`address` varchar(90),
`postalnumber` int null,
`phone` int(8) not null,
`email` varchar(90),
`id` int auto_increment primary key,
`password` varchar(45),
`role` varchar(20) NOT NULL DEFAULT 'customer',
UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `orders` (
`orderId` int auto_increment primary key,
userID int not null,
`length` int not null, 
`width` int not null, 
`height` int not null, 
`orderConfirmed` boolean default false, 
FOREIGN KEY (userID) REFERENCES users(`id`),
`dates` datetime default current_timestamp
);

CREATE TABLE `carports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `model_UNIQUE` (`model` ASC)
  );

insert into users(`name`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('malik sharfo','Somewherevej 25',1455,123456781,'maliksharfo@hotmail.com', 1234, 'admin');
insert into users(`name`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Holm','Somewherevej 26',1455,123456781,'holm@live.dk', 1234, 'customer');
SET FOREIGN_KEY_CHECKS=1;
-- test test test 

