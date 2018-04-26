DROP DATABASE IF EXISTS `FogUsers`;

CREATE DATABASE `FogUsers`;

USE `FogUsers`;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `carports`;

create table `users` (
`email` varchar(90),
`id` int auto_increment primary key,
`password` varchar(45),
`role` varchar(20) NOT NULL DEFAULT 'customer',
UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

insert into users(`email`, `password`, `role`) values('maliksharfo@hotmail.com', 1234, 'admin');

-- test test test 

