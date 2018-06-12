DROP DATABASE IF EXISTS `FogUsers`;

CREATE DATABASE `FogUsers`;

USE `FogUsers`;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `inventory`;
DROP TABLE IF EXISTS `itemlist`;

create table `users` (
`id` int auto_increment primary key,
`name` varchar(90),
`lastname` varchar(90),
`address` varchar(90),
`postalnumber` int null,
`phone` int(8) not null,
`email` varchar(90),
`password` varchar(45),
`role` varchar(20) NOT NULL DEFAULT 'customer',
UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `orders` (
`orderId` int auto_increment primary key,
`userID` int not null,
`length` int not null, 
`width` int not null, 
`height` int not null, 
`price` int not null, 
`orderConfirmed` boolean default false, 
`dates` datetime default current_timestamp,
FOREIGN KEY (userID) REFERENCES users(`id`) 
)AUTO_INCREMENT=1;

CREATE TABLE `inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL UNIQUE,
  `description` VARCHAR(100) NOT NULL,
  `length` INT,
  `unit` VARCHAR(45),  
  `status` INT,
  `price` INT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
  )AUTO_INCREMENT=1;
  
  CREATE TABLE `itemlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orderid` INT NOT NULL,  
  `name` VARCHAR(150) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `length` INT,
  `unit` VARCHAR(45),
  `amount` INT,
  `itemId` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
  )AUTO_INCREMENT=1;
  
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Admin','Admin','Somewherevej 25',1455,12345678,'admin@admin.com', 1234, 'admin');
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Customer','Customer','Somewherevej 26',1455,24681357,'customer@customer.com', 1234, 'customer');
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Seller','Seller','Somewherevej 27',1455,24681357,'seller@seller.com', 1234, 'seller');
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Storagechief','Storagechief','Somewherevej 28',1455,24681357,'storagechief@storagechief.com', 1234, 'storagechief');
insert into users(`name`,`lastname`,`address`,`postalnumber`,`phone`,`email`, `password`, `role`) values('Storageworker','Storageworker','Somewherevej 29',1455,24681357,'storageworker@storageworker.com', 1234, 'storageworker');

insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('25x200 mm. trykimp. bræt - 360 understern', '360', 'stk.', 'Understernsbrædder til for & bag ende', '1000', '250');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('25x200 mm. trykimp. bræt - 540 understern', '540', 'stk', 'Understernsbrædder til siderne', '1000', '500');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('25x125 mm. trykimp. bræt - 360 overstern', '360', 'stk', 'Oversternsbrædder til forenden', '1000', '600');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('25x125 mm. trykimp. bræt - 540 overstern', '540', 'stk', 'Understernsbrædder til siderne', '1000', '1250');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('38x73	mm.	Lægte	ubh.', '420', 'stk', 'Til	z	på	bagside	af	dør', '1000', '400');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('45x95 mm. Reglar ub. - 270', '270', 'stk', 'Løsholter til skur gavle', '1000', '100');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('45x95 mm. Reglar ub. - 240', '240', 'stk', 'Løsholter til skur sider', '1000', '700');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('45x195 mm. spærtræ ubh. - 600 rem', '600', 'stk', 'Remme i sider, sadles ned i stolper', '1000', '199');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('45x195 mm. spærtræ ubh. - 480', '480', 'stk', 'Remme i sider, sadles ned i stolper ( skur del, deles)', '1000', '125');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('45x195 mm. spærtræ ubh. - 600 spær', '600', 'stk', 'Spær, monteres på rem', '1000', '765');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('97x97 mm. trykimp. Stolpe', '300', 'stk', 'Stolper, nedgraves 90 cm. i jord', '1000', '890');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('19x100 mm. trykimp. bræt - 210', '210', 'stk', 'Til beklædning af skur 1 på 2', '1000', '442');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('19x100 mm. trykimp. bræt - 540', '540', 'stk', 'Vandbræt på stern i sider', '1000', '623');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('19x100 mm. trykimp. bræt - 360', '360', 'stk', 'Vandbræt på stern i forende', '1000', '325');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('Plastmo Ecolite blåtonet - 600', '600', 'stk', 'Tagplader monteres på spær', '1000', '1500');
insert into inventory(`name`, `length`, `unit`, `description`, `status`, `price`) values('Plastmo Ecolite blåtonet - 360', '360', 'stk', 'Tagplader monteres på spær', '1000', '3000');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Plastmo bundskruer 200 stk.', 'pakke', 'Skruer til tagplader', '1000', '200');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Hulbånd 1x20 mm. 10 mtr.', 'rulle', 'Til vindkryds på spær', '1000', '220');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Universal 190 mm. højre', 'stk', 'Til montering af spær på rem', '1000', '212');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Universal 190 mm. venstre', 'stk', 'Til montering af spær på rem', '1000', '900');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('4.5x60 mm. skruer 200 stk.', 'pakke', 'Til montering på stern & vandbræt', '1000', '50');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('4.0x50 mm. beslagskruer 250 stk.', 'pakke','Til montering af universalbeslag + hulbånd', '1000', '350');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Bræddebolt 10x120 mm.', 'stk', 'Til montering af rem og stolper', '1000', '640');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Firkantskiver 40x40x11 mm.', 'stk', 'Til montering af rem og stolper', '1000', '932');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('4.5x70 mm. skruer 400 stk.', 'pakke', 'Til montering af yderste beklædning', '1000', '155');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('4.5x50 mm. Skruer 300 stk.', 'pakke', 'Til montering af inderste beklædning', '1000', '37');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Stalddørsgreb 50x75', 'sæt', 'Til lås på dør i skur', '1000', '180');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('T hængsel 390 mm.', 'stk', 'Til skurdør', '1000', '10');
insert into inventory(`name`, `unit`, `description`, `status`, `price`) values('Vinkelbeslag 35', 'stk', 'Til montering af løsholter i skur', '1000', '7');

SET FOREIGN_KEY_CHECKS=1;



