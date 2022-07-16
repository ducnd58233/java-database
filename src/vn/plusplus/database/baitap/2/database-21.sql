#Create database
CREATE DATABASE IF NOT EXISTS student_cms_plusplus DEFAULT CHARACTER SET utf8mb4;
USE student_cms_plusplus;

#Create tables
CREATE TABLE IF NOT EXISTS student (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `mssv` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `age` INT NULL,
  `email` VARCHAR(45) NULL,
  `created_timestamp` TIMESTAMP NULL,
  `last_updated_timestamp` TIMESTAMP NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS class (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `major` VARCHAR(45) NULL,
    `total_student` INT NULL,
    `teacher_name` VARCHAR(45) NULL,
    `teacher_phone` VARCHAR(45) NULL,
    `created_timestamp` TIMESTAMP NULL,
    `last_updated_timestamp` TIMESTAMP NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS student_class (
	`student_id` INT NULL,
    `class_id` INT NULL
);

#Insert data
INSERT INTO student (`name`, `mssv`, `password`, `phone`, `address`, `age`, `email`)
VALUES ('duc', '1', '123', '0000000', 'abc', '21', 'duc@example.com');

INSERT INTO class (`name`, `major`, `total_student`, `teacher_name`, `teacher_phone`)
VALUES ('A', 'IT', '40', 'Kiem', '0123456789');

INSERT INTO student_class (`student_id`, `class_id`)
VALUES (1, 1);