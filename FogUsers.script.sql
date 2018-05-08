DROP DATABASE IF EXISTS `FogUsers`;

CREATE DATABASE `FogUsers`;

USE `FogUsers`;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `carports`;
DROP TABLE IF EXISTS `storage`;
DROP TABLE IF EXISTS `itemlist`;

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

CREATE TABLE `storage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `length` INT,
  `unit` VARCHAR(45),   
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
  );
  
  CREATE TABLE `itemlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `length` INT,
  `amount` INT,
  `unit` VARCHAR(45),
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
  );
  
insert into users(`name`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('malik sharfo','Somewherevej 25',1455,123456781,'maliksharfo@hotmail.com', 1234, 'admin');
insert into users(`name`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Holm','Somewherevej 26',1455,123456781,'holm@live.dk', 1234, 'customer');
insert into users(`name`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('bambi','Bambivej',1455,123456781,'bambi@bambi.dk', 1234, 'customer');

insert into storage(`name`, `length`, `unit`, `description`) values('25x200 mm. trykimp. bræt', '360', 'stk.', 'Understernsbrædder til for & bag ende');
insert into storage(`name`, `length`, `unit`, `description`) values('25x200 mm. trykimp. bræt', '540', 'stk', 'Understernsbrædder til siderne');
insert into storage(`name`, `length`, `unit`, `description`) values('25x125 mm. trykimp. bræt', '360', 'stk', 'Oversternsbrædder til forenden');
insert into storage(`name`, `length`, `unit`, `description`) values('25x125 mm. trykimp. bræt', '540', 'stk', 'Understernsbrædder til siderne');
insert into storage(`name`, `length`, `unit`, `description`) values('38x73	mm.	Lægte	ubh.', '420', 'stk', 'Til	z	på	bagside	af	dør');
insert into storage(`name`, `length`, `unit`, `description`) values('45x95 mm. Reglar ub.', '270', 'stk', 'Løsholter til skur gavle');
insert into storage(`name`, `length`, `unit`, `description`) values('45x95 mm. Reglar ub.', '240', 'stk', 'Løsholter til skur sider');
insert into storage(`name`, `length`, `unit`, `description`) values('45x195 mm. spærtræ ubh.', '600', 'stk', 'Remme i sider, sadles ned i stolper');
insert into storage(`name`, `length`, `unit`, `description`) values('45x195 mm. spærtræ ubh.', '480', 'stk', 'Remme i sider, sadles ned i stolper ( skur del, deles)');
insert into storage(`name`, `length`, `unit`, `description`) values('45x195 mm. spærtræ ubh.', '600', 'stk', 'Spær, monteres på rem');
insert into storage(`name`, `length`, `unit`, `description`) values('97x97 mm. trykimp. Stolpe', '300', 'stk', 'Stolper, nedgraves 90 cm. i jord');
insert into storage(`name`, `length`, `unit`, `description`) values('19x100 mm. trykimp. bræt', '210', 'stk', 'Til beklædning af skur 1 på 2');
insert into storage(`name`, `length`, `unit`, `description`) values('19x100 mm. trykimp. bræt', '540', 'stk', 'Vandbræt på stern i sider');
insert into storage(`name`, `length`, `unit`, `description`) values('19x100 mm. trykimp. bræt', '360', 'stk', 'Vandbræt på stern i forende');
insert into storage(`name`, `length`, `unit`, `description`) values('Plastmo Ecolite blåtonet', '600', 'stk', 'Tagplader monteres på spær');
insert into storage(`name`, `length`, `unit`, `description`) values('Plastmo Ecolite blåtonet', '360', 'stk', 'Tagplader monteres på spær');
insert into storage(`name`, `unit`, `description`) values('Plastmo bundskruer 200 stk.', 'pakke', 'Skruer til tagplader');
insert into storage(`name`, `unit`, `description`) values('Hulbånd 1x20 mm. 10 mtr.', 'rulle', 'Til vindkryds på spær');
insert into storage(`name`, `unit`, `description`) values('Universal 190 mm. højre', 'stk', 'Til montering af spær på rem');
insert into storage(`name`, `unit`, `description`) values('Universal 190 mm. venstre', 'stk', 'Til montering af spær på rem');
insert into storage(`name`, `unit`, `description`) values('4.5x60 mm. skruer 200 stk.', 'pakke', 'Til montering på stern & vandbræt');
insert into storage(`name`, `unit`, `description`) values('4.0x50 mm. beslagskruer 250 stk.', 'pakke','Til montering af universalbeslag + hulbånd');
insert into storage(`name`, `unit`, `description`) values('Bræddebolt 10x120 mm.', 'stk', 'Til montering af rem og stolper');
insert into storage(`name`, `unit`, `description`) values('Firkantskiver 40x40x11 mm.', 'stk', 'Til montering af rem og stolper');
insert into storage(`name`, `unit`, `description`) values('4.5x70 mm. skruer 400 stk.', 'pakke', 'Til montering af yderste beklædning');
insert into storage(`name`, `unit`, `description`) values('4.5x50 mm. Skruer 300 stk.', 'pakke', 'Til montering af inderste beklædning');
insert into storage(`name`, `unit`, `description`) values('Stalddørsgreb 50x75', 'sæt', 'Til lås på dør i skur');
insert into storage(`name`, `unit`, `description`) values('T hængsel 390 mm.', 'stk', 'Til skurdør');
insert into storage(`name`, `unit`, `description`) values('Vinkelbeslag 35', 'stk', 'Til montering af løsholter i skur');
SET FOREIGN_KEY_CHECKS=1;

-- test test test 

