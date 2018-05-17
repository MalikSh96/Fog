DROP DATABASE IF EXISTS `FogUsers`;

CREATE DATABASE `FogUsers`;

USE `FogUsers`;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `carports`;
DROP TABLE IF EXISTS `inventory`;
DROP TABLE IF EXISTS `itemlist`;

create table `users` (
`name` varchar(90),
`lastname` varchar(90),
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

CREATE TABLE `inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `length` INT,
  `unit` VARCHAR(45),  
  `status` INT,
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
  
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Malik','Sharfo','Somewherevej 25',1455,12345678,'maliksharfo@hotmail.com', 1234, 'admin');
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Dennis','Holm','Somewherevej 26',1455,24681357,'holm@live.dk', 1234, 'customer');
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Dennis','Holm','Somewherevej 26',1455,24681357,'holm@holm.dk', 1234, 'admin');
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Bambo','Bambi','Bambivej',1455,87654321,'bambi@bambi.dk', 1234, 'customer');

insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('25x200 mm. trykimp. bræt', '360', 'stk.', 'Understernsbrædder til for & bag ende', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('25x200 mm. trykimp. bræt', '540', 'stk', 'Understernsbrædder til siderne', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('25x125 mm. trykimp. bræt', '360', 'stk', 'Oversternsbrædder til forenden', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('25x125 mm. trykimp. bræt', '540', 'stk', 'Understernsbrædder til siderne', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('38x73	mm.	Lægte	ubh.', '420', 'stk', 'Til	z	på	bagside	af	dør', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('45x95 mm. Reglar ub.', '270', 'stk', 'Løsholter til skur gavle', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('45x95 mm. Reglar ub.', '240', 'stk', 'Løsholter til skur sider', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('45x195 mm. spærtræ ubh.', '600', 'stk', 'Remme i sider, sadles ned i stolper', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('45x195 mm. spærtræ ubh.', '480', 'stk', 'Remme i sider, sadles ned i stolper ( skur del, deles)', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('45x195 mm. spærtræ ubh.', '600', 'stk', 'Spær, monteres på rem', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('97x97 mm. trykimp. Stolpe', '300', 'stk', 'Stolper, nedgraves 90 cm. i jord', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('19x100 mm. trykimp. bræt', '210', 'stk', 'Til beklædning af skur 1 på 2', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('19x100 mm. trykimp. bræt', '540', 'stk', 'Vandbræt på stern i sider', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('19x100 mm. trykimp. bræt', '360', 'stk', 'Vandbræt på stern i forende', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('Plastmo Ecolite blåtonet', '600', 'stk', 'Tagplader monteres på spær', '20');
insert into inventory(`name`, `length`, `unit`, `description`, `status`) values('Plastmo Ecolite blåtonet', '360', 'stk', 'Tagplader monteres på spær', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Plastmo bundskruer 200 stk.', 'pakke', 'Skruer til tagplader', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Hulbånd 1x20 mm. 10 mtr.', 'rulle', 'Til vindkryds på spær', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Universal 190 mm. højre', 'stk', 'Til montering af spær på rem', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Universal 190 mm. venstre', 'stk', 'Til montering af spær på rem', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('4.5x60 mm. skruer 200 stk.', 'pakke', 'Til montering på stern & vandbræt', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('4.0x50 mm. beslagskruer 250 stk.', 'pakke','Til montering af universalbeslag + hulbånd', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Bræddebolt 10x120 mm.', 'stk', 'Til montering af rem og stolper', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Firkantskiver 40x40x11 mm.', 'stk', 'Til montering af rem og stolper', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('4.5x70 mm. skruer 400 stk.', 'pakke', 'Til montering af yderste beklædning', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('4.5x50 mm. Skruer 300 stk.', 'pakke', 'Til montering af inderste beklædning', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Stalddørsgreb 50x75', 'sæt', 'Til lås på dør i skur', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('T hængsel 390 mm.', 'stk', 'Til skurdør', '20');
insert into inventory(`name`, `unit`, `description`, `status`) values('Vinkelbeslag 35', 'stk', 'Til montering af løsholter i skur', '20');
SET FOREIGN_KEY_CHECKS=1;



