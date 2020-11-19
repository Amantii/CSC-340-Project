#create new database
create database hospital_DB;


#show databases
show databases;

#use the newly created DB
use hospital_DB;

drop table if exists patients_info;

CREATE TABLE `hospital_DB`.`patients_info` (
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  `street_address` VARCHAR(45) NULL,
  `city` VARCHAR(30) NULL,
  `state` VARCHAR(45) NULL,
  `zipcode` INT NULL,
  `country` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `condition` VARCHAR(45) NULL,
   `patient_id` INT(11) NOT NULL ,
  PRIMARY KEY (`patient_id`));

drop table if exists `employee_table`;

CREATE TABLE `hospital_DB`.`employee_table` (
 `employee_id` INT(11) NOT NULL ,
 `first_name` VARCHAR(30) NOT NULL ,
  `last_name` VARCHAR(30) NULL DEFAULT NULL ,
  `email` VARCHAR(30) NOT NULL ,
 `department` VARCHAR(30) NULL DEFAULT NULL ,
 `phone_num` INT(14) NULL DEFAULT NULL ,
`office` VARCHAR(30) NULL DEFAULT NULL ,
 `specialty` VARCHAR(30) NULL DEFAULT NULL , 
 PRIMARY KEY (`employee_id`));


drop table if exists appointment;

CREATE TABLE `hospital_DB`.`appointment` (
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `appointment_start` DATETIME NOT NULL,
  `appointment_end` DATETIME NOT NULL,
  `patient_name` VARCHAR(45) NULL,
  `patient_session` VARCHAR(45) NOT NULL,
  `employee_id` INT NOT NULL,
  PRIMARY KEY (`appointment_id`));


INSERT INTO `patients_info` (`employee_id`,`first_name`,`last_name`,`email`,`department`,`phone_num`,`office`,`specialty`) VALUES ('88121','Callie','Ray','cray@gmail.com','Dr','704-333-0111', 'room208','Oncology');
INSERT INTO `employee_table` (`first_name`,`last_name`,`email`,`phone_number`,`street_address`,`city`,`state`,`zipcode`, `password`, `condition`,`patient_id`) VALUES ('Liz','Jennings','ljennings@gmail.com','704-333-0110', '121 main st','charlotte','NC','28211','USA','password','breast cancer', 51011);
INSERT INTO `appointment` (`appointment_id`,`appointment_start`,`appointment_end`,`patient_name`,`patient_session`,`employee_id`) VALUES(1, '',
SELECT * FROM patients_info;
SELECT * FROM employee_table;

