# Service title

scorer service API
 

## Introduction


This is the main microservice and it gives the adecuate responses needed for the Tictactoe  project. 
In this microservice we mainly have the following information:

-Get the list of players with their scores
-Create a new player
-Increase the score of an existing player

## Setup environment


To set up a local environment from zero, you must create a local schema in mysql by excecuting the following script:

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tic_tac_toe` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema tic_tac_toe
-- -----------------------------------------------------
USE `tic_tac_toe` ;

-- -----------------------------------------------------
-- Table `mydb`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tic_tac_toe`.`player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `score` INT(45) NULL default 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



Note: The local connection must have "root" as password and userame.
 
 ## Key features
 
*Java 11
*SpringBoot 2
*MySQL Database connections (JPA Hibernate)