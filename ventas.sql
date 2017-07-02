DROP database IF exists ventas;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Ventas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Ventas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Ventas` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `Ventas` ;

-- -----------------------------------------------------
-- Table `Ventas`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ventas`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `dni` VARCHAR(8) NOT NULL,
  `ruc` VARCHAR(11) NOT NULL,
  `firstName` VARCHAR(20) NOT NULL,
  `middleName` VARCHAR(45) NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `lastName2` VARCHAR(45) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(15) NOT NULL,
  `customerType` VARCHAR(20) NOT NULL check (customerType in ('FREQUENT','AFFILIATED', 'NORMAL')),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC),
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ventas`.`Sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ventas`.`Sale` (
  `idSale` INT NOT NULL AUTO_INCREMENT,
  `saleDate` TIMESTAMP NOT NULL,
  `total` DECIMAL(10,0) NOT NULL DEFAULT 0,
  `totalDiscount` DECIMAL(10,0) NOT NULL DEFAULT 0,
  `state` VARCHAR(20) NOT NULL check (state in ('PAID','CONFIRMED', 'BUYING')),
  `idCustomer` INT NOT NULL,
  PRIMARY KEY (`idSale`),
  INDEX `fk_Sale_Customer1_idx` (`idCustomer` ASC),
  CONSTRAINT `fk_Sale_Customer1`
    FOREIGN KEY (`idCustomer`)
    REFERENCES `Ventas`.`Customer` (`idCustomer`)
    ON DELETE no action
    ON UPDATE no action)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ventas`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ventas`.`Category` (
  `idCategory` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `description` VARCHAR(100) NULL,
  PRIMARY KEY (`idCategory`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ventas`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ventas`.`Product` (
  `idProduct` INT NOT NULL,
  `name` VARCHAR(300) NOT NULL,
  `description` VARCHAR(300) NULL,
  `price` DECIMAL(5,2) NOT NULL,
  `stock` INT NOT NULL,
  `image` VARCHAR(400) NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ventas`.`SaleDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ventas`.`SaleDetail` (
  `idProduct` INT NOT NULL,
  `idSale` INT NOT NULL,
  `quantity` INT NOT NULL,
  `discount` DECIMAL(10,0) NOT NULL DEFAULT 0,
  `subtotal` DECIMAL(10,0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idProduct`, `idSale`),
  INDEX `fk_SaleDetail_Sale1_idx` (`idSale` ASC),
  CONSTRAINT `fk_SaleDetail_Product1`
    FOREIGN KEY (`idProduct`)
    REFERENCES `Ventas`.`Product` (`idProduct`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_SaleDetail_Sale1`
    FOREIGN KEY (`idSale`)
    REFERENCES `Ventas`.`Sale` (`idSale`)
    ON DELETE no action
    ON UPDATE no action)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ventas`.`ProductCategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ventas`.`ProductCategory` (
  `idCategory` INT NOT NULL,
  `idProduct` INT NOT NULL,
  PRIMARY KEY (`idCategory`, `idProduct`),
  INDEX `fk_Category_has_Product_Product1_idx` (`idProduct` ASC),
  INDEX `fk_Category_has_Product_Category1_idx` (`idCategory` ASC),
  CONSTRAINT `fk_Category_has_Product_Category1`
    FOREIGN KEY (`idCategory`)
    REFERENCES `Ventas`.`Category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Category_has_Product_Product1`
    FOREIGN KEY (`idProduct`)
    REFERENCES `Ventas`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
